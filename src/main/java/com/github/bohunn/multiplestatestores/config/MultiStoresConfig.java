package com.github.bohunn.multiplestatestores.config;

import avro.ch.tkb.bde.JoinedBpAddrV2;
import avro.ch.tkb.bde.JoinedPersonAddrV2;
import avro.ch.tkb.bde.ObjectUpdateEvent;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;

import java.util.HashMap;
import java.util.Map;

import static com.github.bohunn.multiplestatestores.config.Helper.*;

@Configuration
@EnableKafkaStreams
public class MultiStoresConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.schema-registry-url}")
    private String schemaRegistryUrl;

    @Value("${spring.kafka.security.protocol}")
    private String securityProtocol;

    @Value("${kafka.config.providers.cluster.secret:dummy}")
    private String configProviderClusterSecret;

    @Value("${kafka.config.providers.user.secret:dummy}")
    private String configProviderUserSecret;

    @Value("${bp.addr.input.topic.name}")
    private String bpAddrInputTopicName;

    @Value("${person.addr.input.topic.name}")
    private String personAddrInputTopicName;

    @Value("${joined.bp.addr.output.topic.name}")
    private String joinedBpAddrOutputTopicName;

    @Value("${spring.kafka.streams.application-id}")
    private String streamerApplicationId;

    @Bean
    public SpecificAvroSerde<JoinedBpAddrV2> joinedBpAddrSerde() {
        return new SpecificAvroSerde<>();
    }
    @Bean
    public SpecificAvroSerde<JoinedPersonAddrV2> joinedPersonAddrSerde() {
        return new SpecificAvroSerde<>();
    }
    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_BUILDER_BEAN_NAME)
    public StreamsBuilderFactoryBean joinerStreamsBuilder(KafkaStreamsConfiguration configuration) {
        return new StreamsBuilderFactoryBean(configuration);
    }
    @Bean
    public SpecificAvroSerde<ObjectUpdateEvent> objectUpdateEventSerde() {
        return new SpecificAvroSerde<>();
    }

    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    KafkaStreamsConfiguration kStreamsConfigs() {
        Map<String, Object> properties = new HashMap<>();

        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, streamerApplicationId);
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class);
        properties.put(StreamsConfig.STATE_DIR_CONFIG, "/tmp/kafka-streams");
        properties.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistryUrl);
        properties.put(BP_ADDR_TOPIC, bpAddrInputTopicName);
        properties.put(PERSON_ADDR_TOPIC, personAddrInputTopicName);
        properties.put(OBJECT_UPDATE_EVENT_TOPIC, joinedBpAddrOutputTopicName);
        if (securityProtocol.equals("SSL")) {
            properties.put("config.providers", "secrets");
            properties.put("config.providers.secrets.class", "io.strimzi.kafka.KubernetesSecretConfigProvider");
            properties.put(SslConfigs.SSL_TRUSTSTORE_TYPE_CONFIG, "PEM");
            properties.put(SslConfigs.SSL_TRUSTSTORE_CERTIFICATES_CONFIG, String.format("${secrets:%s}", configProviderClusterSecret));
            properties.put(SslConfigs.SSL_KEYSTORE_TYPE_CONFIG, "PEM");
            properties.put(SslConfigs.SSL_KEYSTORE_CERTIFICATE_CHAIN_CONFIG, String.format("${secrets:%s:user.crt}", configProviderUserSecret));
            properties.put(SslConfigs.SSL_KEYSTORE_KEY_CONFIG, String.format("${secrets:%s:user.key}", configProviderUserSecret));
            properties.put(StreamsConfig.SECURITY_PROTOCOL_CONFIG, securityProtocol);
        }
        return new KafkaStreamsConfiguration(properties);
    }
}
