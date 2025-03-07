package co.com.spike.spring.cloud.stream.kafka_stream_consumption.general.utils;


import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto.EventEntityDTO;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto.util.CommandDataToll;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto.util.EventEntityBodyDTO;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto.util.EventEntityHeaderDTO;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.general.constants.Constants;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GenerateEventsUtil {

    public EventEntityHeaderDTO generateEventHeader(String correlationId) {
        return new EventEntityHeaderDTO(correlationId);
    }

    public EventEntityBodyDTO generateEventBody(String eventName,
                                                String domainEntity,
                                                String dateTime,
                                                String eventType,
                                                CommandDataToll commandData) {
        return new EventEntityBodyDTO(eventName, domainEntity, dateTime, eventType, commandData);
    }

    public EventEntityDTO createEventEntity(CommandDataToll commandData, String eventName, String domainEntity) {
        UUID correlationId = UUID.randomUUID();
        EventEntityHeaderDTO header = generateEventHeader(String.valueOf(correlationId));
        EventEntityBodyDTO body = generateEventBody(eventName,
                domainEntity,
                GenerateTimeStampUtil.generateTimeStamp(),
                Constants.EVENT_TYPE,
                commandData);
        return new EventEntityDTO(header, body);
    }
}