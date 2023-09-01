package com.github.bohunn.multiplestatestores.processor;

import avro.ch.tkb.bde.BpAddrOrPersonAddrV2;
import avro.ch.tkb.bde.JoinedBpAddrV2;
import avro.ch.tkb.bde.JoinedPersonAddrV2;
import avro.ch.tkb.bde.ObjectUpdateEvent;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.processor.api.ContextualProcessor;
import org.apache.kafka.streams.processor.api.Record;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.StoreBuilder;
import org.apache.kafka.streams.state.Stores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import static com.github.bohunn.multiplestatestores.config.Helper.*;

@Component
@Slf4j
public class MultiStoreJoinProcessor {

    public static final String PERSON_STORE_NAME = "person-state-store";
    public static final String BP_STORE_NAME = "bp-state-store";

    @Autowired
    SpecificAvroSerde<JoinedBpAddrV2> joinedBpAddrSerde;

    @Autowired
    SpecificAvroSerde<JoinedPersonAddrV2> joinedPersonAddrSerde;

    @Autowired
    SpecificAvroSerde<ObjectUpdateEvent> objectUpdateEventSerde;

    @Autowired
    KafkaStreamsConfiguration configuration;

    @Bean
    public KStream<String, BpAddrOrPersonAddrV2> buildTopology(StreamsBuilder streamsBuilder) {
        Properties properties = configuration.asProperties();

        final Map<String, String> serdeConfig = Collections.singletonMap(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, properties.getProperty(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG));

        joinedBpAddrSerde.configure(serdeConfig, false);
        joinedPersonAddrSerde.configure(serdeConfig, false);
        objectUpdateEventSerde.configure(serdeConfig, false);

        StoreBuilder<KeyValueStore<String, JoinedBpAddrV2>> bpStoreBuilder = Stores.keyValueStoreBuilder(
                Stores.persistentKeyValueStore(BP_STORE_NAME),
                Serdes.String(),
                joinedBpAddrSerde
        );

        StoreBuilder<KeyValueStore<String, JoinedPersonAddrV2>> personStoreBuilder = Stores.keyValueStoreBuilder(
                Stores.persistentKeyValueStore(PERSON_STORE_NAME),
                Serdes.String(),
                joinedPersonAddrSerde
        );

        streamsBuilder.addStateStore(bpStoreBuilder);
        streamsBuilder.addStateStore(personStoreBuilder);

        // get the streams
        KStream<String, JoinedBpAddrV2> bpStream = streamsBuilder.stream(properties.getProperty(BP_ADDR_TOPIC), Consumed.with(Serdes.String(), joinedBpAddrSerde));
        KStream<String, JoinedPersonAddrV2> personStream = streamsBuilder.stream(properties.getProperty(PERSON_ADDR_TOPIC), Consumed.with(Serdes.String(), joinedPersonAddrSerde));

        // join the streams
        KStream<String, BpAddrOrPersonAddrV2> mergedStream = bpStream
                .mapValues(value -> new BpAddrOrPersonAddrV2(null, value))
                .merge(personStream.mapValues(value -> new BpAddrOrPersonAddrV2(value, null)));

        mergedStream.process(() -> new ContextualProcessor<String, BpAddrOrPersonAddrV2, String, ObjectUpdateEvent>() {
            @Override
            public void process(Record<String, BpAddrOrPersonAddrV2> record) {
                BpAddrOrPersonAddrV2 eitherValue = record.value();
                boolean isHashUpdated = false;

                KeyValueStore<String, JoinedBpAddrV2> bpStore = context().getStateStore(BP_STORE_NAME);
                KeyValueStore<String, JoinedPersonAddrV2> personStore = context().getStateStore(PERSON_STORE_NAME);

                JoinedBpAddrV2 bpAddr = eitherValue.getBpAddr();
                JoinedPersonAddrV2 personAddr = eitherValue.getPersonAddr();

                if (bpAddr != null) {
                    String[] splittedKey = record.key().split(":");
                    String personIdAddrIdKey = String.format("%s:%s", splittedKey[1], splittedKey[2]);

                    boolean isEmittent = isEmittent(bpAddr);

                    if (isRegisteredOwnerId(bpAddr, splittedKey[1]) || isEmittent) {
//                        personId, addrId, bpId
                        String revertedKey = String.format("%s:%s:%s", splittedKey[1], splittedKey[2], splittedKey[0]);

                        // get stored value from bp-addr state store
                        JoinedBpAddrV2 storedValue = bpStore.get(revertedKey);
                        log.info("bpaddr entry storedValue: {}", storedValue);
                        if (storedValue == null) {
                            log.debug("{}, New BpAddr Table Entry for: {}, hash: {}", BP_STORE_NAME, record.key(), bpAddr.getHash());
                            bpStore.put(revertedKey, bpAddr);
                            isHashUpdated = true;
                        } else if (!Objects.equals(storedValue.getHash(), bpAddr.getHash())) {
                            log.debug("{}, Update BpAddr Entry for key: {}, old hash: {}, new hash: {}", BP_STORE_NAME, record.key(), storedValue.getHash(), bpAddr.getHash());
                            bpStore.put(revertedKey, bpAddr);
                            isHashUpdated = true;
                        } else {
                            log.debug("{}, No hash change do nothing for BpAddr key:{} hash value:{}", BP_STORE_NAME, record.key(), storedValue.getHash());
                        }
                    }

                    if (isHashUpdated) {
                        log.info("SEARCHING IN PERSON - ADDR STATE STORE WITH A KEY: {}", personIdAddrIdKey);

                        JoinedPersonAddrV2 matching = personStore.get(personIdAddrIdKey);
                        log.info("MATCHING: {}", matching);

                        KeyValueIterator<String, JoinedPersonAddrV2> matchedPersonAddrIterator = personStore.prefixScan(personIdAddrIdKey, new StringSerializer());

                        if (matchedPersonAddrIterator.hasNext()) {
                            while (matchedPersonAddrIterator.hasNext()) {
                                JoinedPersonAddrV2 matchedPersonAddr = matchedPersonAddrIterator.next().value;
                                // if the bp-addr is an emmitent and didn't find mathing personAddr look with just personId using prefix scan
                                // because addrId is not propagated on bp, therefore they might have a different domiAddr on bp and person
                                if (matchedPersonAddr == null && isEmittent) {
                                    String personId = splittedKey[1];
                                    // do a prefix scan for a personId
                                    KeyValueIterator<String, JoinedPersonAddrV2> joinedPersonIterator = personStore.prefixScan(personId, new StringSerializer());
                                    while (joinedPersonIterator.hasNext()) {
                                        JoinedPersonAddrV2 item = joinedPersonIterator.next().value;
                                        context().forward(record.withKey(personIdAddrIdKey).withValue(createObjectUpdateEvent(item, bpAddr)));
                                    }
                                    // "standard" match forward the record
                                } else if (matchedPersonAddr != null) {
                                    context().forward(record.withKey(personIdAddrIdKey).withValue(createObjectUpdateEvent(matchedPersonAddr, bpAddr)));
                                }
                            }
                        }
                    }

                } else if (personAddr != null) { // process if person-addr record is coming

                    if (record.value() != null) {
                        JoinedPersonAddrV2 storedValue = personStore.get(record.key());
                        log.info("personaddr entry storedValue: {}", storedValue);

                        if (storedValue == null) {
                            log.debug("{}, New PersonAddr Table entry for: {}, hash: {}", PERSON_STORE_NAME, record.key(), personAddr.getHash());
                            personStore.put(record.key(), personAddr);
                            isHashUpdated = true;
                        } else if (!storedValue.getHash().equals(personAddr.getHash())) {
                            log.debug("{}, Update PersonAddr Table entry for: {}, old hash: {}, new hash: {}", PERSON_STORE_NAME, record.key(), storedValue.getHash(), personAddr.getHash());
                            personStore.put(record.key(), personAddr);
                            isHashUpdated = true;
                        } else {
                            log.debug("{}, No hash change do nothing for PersonAddr key: {}, hash: {}", PERSON_STORE_NAME, record.key(), personAddr.getHash());
                        }
                    } else {
                        log.debug("Got NULL JoinedPersonAddr Object - skip! --> key: {}", record.key());
                    }

                    if (isHashUpdated) {
                        try {

                            // look for matches in bpAddr store
                            log.info("SEARCHING IN BP - ADDR STATE STORE WITH A KEY: {}", record.key());
                            KeyValueIterator<String, JoinedBpAddrV2> bpAddrIterator = bpStore.prefixScan(record.key(), new StringSerializer());

                            if (bpAddrIterator.hasNext()) {
                                log.trace("Found records for key {} record in {}", record.key(), BP_STORE_NAME);
                                // got matches for given personId:addrId update all found records
                                while (bpAddrIterator.hasNext()) {
                                    JoinedBpAddrV2 bpAddrObject = bpAddrIterator.next().value;
                                    context().forward(record.withKey(record.key()).withValue(createObjectUpdateEvent(personAddr, bpAddrObject)));
                                }
                            } else {
                                log.trace("Found NO records for key {} record in {}", record.key(), BP_STORE_NAME);
                                String[] splittedKey = record.key().split(":");
                                final String ZERO = "0";

                                // only when addr != 0 and is emittent
                                if (personAddr.getIsEmittent() && !splittedKey[1].equals(ZERO)) {
                                    String personIdNullAddrKey = String.format("%s:%s", splittedKey[0], ZERO);
//                                look for records in bp-addr state store with key personId:0
                                    KeyValueIterator<String, JoinedBpAddrV2> bpNullAddrIterator = bpStore.prefixScan(personIdNullAddrKey, new StringSerializer());
                                    if (bpNullAddrIterator.hasNext()) {
                                        log.trace("Found records for key {} record in {}", personIdNullAddrKey, BP_STORE_NAME);
                                        while (bpNullAddrIterator.hasNext()) {
                                            JoinedBpAddrV2 bpAddrV2 = bpNullAddrIterator.next().value;
                                            context().forward(record.withKey(record.key()).withValue(createObjectUpdateEvent(personAddr, bpAddrV2)));
                                        }
                                    }
                                } else {
                                    log.trace("Found NO matched sending PERSON_ONLY records");
                                    // no match in bpAddr state store send PERSON_ONLY event
                                    context().forward(record.withValue(createObjectUpdateEvent(personAddr, null)));
                                }
                            }
                        } catch (Exception e) {
                            log.error("EXCEPTION : {}", e.getMessage());
                        }
                    }
                }
            }
                }, BP_STORE_NAME, PERSON_STORE_NAME)
                .peek((key, value) -> log.debug("Produced Update Event key: {}, hash: {}", key, value.getHash()))
                .to(properties.getProperty(OBJECT_UPDATE_EVENT_TOPIC), Produced.with(Serdes.String(), objectUpdateEventSerde));

        return mergedStream;
    }
}
