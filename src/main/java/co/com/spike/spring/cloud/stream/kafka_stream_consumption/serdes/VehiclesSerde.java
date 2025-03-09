package co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes;

import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.Vehicles;
import org.apache.kafka.common.serialization.Serdes;

public final class VehiclesSerde extends Serdes.WrapperSerde<Vehicles> {
    public VehiclesSerde() {
        super(new JsonSerializer<>(), new JsonDeserializer<>(Vehicles.class));
    }
}