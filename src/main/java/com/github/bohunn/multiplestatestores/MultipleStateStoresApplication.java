package com.github.bohunn.multiplestatestores;

import java.beans.BeanProperty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.StreamsBuilder;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerializer;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.common.serialization.Serdes;
import java.util.Map;
import java.util.HashMap;
import com.github.bohunn.multiplestatestores.avro.JoinedBpAddrV2;
import com.github.bohunn.multiplestatestores.avro.JoinedPersonAddrV2;
import com.github.bohunn.multiplestatestores.avro.ObjectUpdateEvent;

@SpringBootApplication
@EnableKafkaStreams
public class MultipleStateStoresApplication {

    public static final String PERSON_STORE_NAME = "person-state-store";
    public static final String BP_STORE_NAME = "person-state-store";

    public static void main(String[] args) {
        SpringApplication.run(MultipleStateStoresApplication.class, args);
    }

    @Bean
    public KafkaStreamsConfiguration kafkaStreamsConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "joiner-application");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        return new KafkaStreamsConfiguration(props);
    }

    @Bean
    public SpecificAvroSerde<JoinedBpAddrV2> joinedBpAddrSerde() {
        return Serdes.serdeFrom(new SpecificAvroSerializer<>(), new SpecificAvroDeserializer<>());
    }

    @Bean
    public SpecificAvroSerde<JoinedPersonAddrV2> joinedPersonAddrSerde() {
        return Serdes.serdeFrom(new SpecificAvroSerializer<>(), new SpecificAvroDeserializer<>());
    }

    @Bean
    public SpecificAvroSerde<ObjectUpdateEvent> objectUpdateEventSerde() {
        return Serdes.serdeFrom(new SpecificAvroSerializer<>(), new SpecificAvroDeserializer<>());
    }

    @Bean
    public StreamsBuilderFactoryBean myStreamBuilder(KafkaStreamsConfiguration configuration) {
        return new StreamsBuilderFactoryBean(configuration);
    }

    // // // @Bean
    // // public StreamsBuilder<String, MyAvroClass> kStream(KStreamBuilder kStreamBuilder) {

    //     kStreamBuilder.
    //     stream.to("output-topic");

    //     return stream;
    // }
}
