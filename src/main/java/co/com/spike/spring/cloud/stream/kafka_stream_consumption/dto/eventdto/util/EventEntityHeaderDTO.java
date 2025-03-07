package co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EventEntityHeaderDTO {
    private String traceId;

    public EventEntityHeaderDTO(String traceId){
        this.traceId =  traceId;
    }
}