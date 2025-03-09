package co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes;

import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.MovementsAttentionsPointsConsultation;
import org.apache.kafka.common.serialization.Serdes;

public final class MovementsAttentionsPointsConsultationSerde extends Serdes.WrapperSerde<MovementsAttentionsPointsConsultation> {
    public MovementsAttentionsPointsConsultationSerde() {
        super(new JsonSerializer<>(), new JsonDeserializer<>(MovementsAttentionsPointsConsultation.class));
    }
}
