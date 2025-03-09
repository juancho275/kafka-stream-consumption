package co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes;

import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.AttentionPoint;
import org.apache.kafka.common.serialization.Serdes;

public final class AttentionPointSerde extends Serdes.WrapperSerde<AttentionPoint> {
    public AttentionPointSerde() {
        super(new JsonSerializer<>(), new JsonDeserializer<>(AttentionPoint.class));
    }
}