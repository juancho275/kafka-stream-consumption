package co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto;


import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto.util.EventEntityBodyDTO;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto.util.EventEntityHeaderDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class EventEntityDTO {
    private EventEntityHeaderDTO header;
    private EventEntityBodyDTO body;

    public EventEntityDTO(EventEntityHeaderDTO header, EventEntityBodyDTO body) {
        this.header = header;
        this.body = body;
    }
}