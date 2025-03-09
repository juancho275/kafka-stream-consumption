package co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes;

import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.AdjustmentFlypass;
import org.apache.kafka.common.serialization.Serdes;

public final class AdjustmentFlypassSerde extends Serdes.WrapperSerde<AdjustmentFlypass> {
    public AdjustmentFlypassSerde() {
        super(new JsonSerializer<>(), new JsonDeserializer<>(AdjustmentFlypass.class));
    }
}

