package co.com.spike.spring.cloud.stream.kafka_stream_consumption.store;

import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.AdjustmentFlypass;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.AttentionPoint;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.Vehicles;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.GlobalKTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.Stores;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.support.serializer.JsonSerde;

@Configuration
@EnableKafkaStreams
@Slf4j
public class ConfigStores {
    @Bean
    public GlobalKTable<String, Vehicles> vehicleStore(StreamsBuilder streamsBuilder) {
        log.info("Creando GlobalKTable para vehículos");
        return streamsBuilder.globalTable(
                "dev_internal_oracle_to_cloud_vehicles_topic_events",
                Materialized.<String, Vehicles, KeyValueStore<Bytes, byte[]>>as("vehicleStore")
                        .withKeySerde(Serdes.String())
                        .withValueSerde(new JsonSerde<>(Vehicles.class))
        );
    }

    @Bean
    public GlobalKTable<String, AttentionPoint> attentionPointStore(StreamsBuilder streamsBuilder) {
        log.info("Creando GlobalKTable para punto de atencion");
        return streamsBuilder.globalTable(
                "dev_internal_oracle_to_cloud_attention_points_topic_events",
                Materialized.<String, AttentionPoint, KeyValueStore<Bytes, byte[]>>as("attentionPointStore")
                        .withKeySerde(Serdes.String())
                        .withValueSerde(new JsonSerde<>(AttentionPoint.class))
        );
    }

    @Bean
    public GlobalKTable<String, AdjustmentFlypass> adjustmentFlypassStore(StreamsBuilder streamsBuilder) {
        log.info("Creando GlobalKTable para Ajustes");
        return streamsBuilder.globalTable(
                "dev_internal_oracle_to_cloud_interoperability_adjustments_flypass_topic_events",
                Materialized.<String, AdjustmentFlypass, KeyValueStore<Bytes, byte[]>>as("adjustmentFlypassStore")
                        .withKeySerde(Serdes.String())
                        .withValueSerde(new JsonSerde<>(AdjustmentFlypass.class))
        );
    }
}
