package co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventEntityBodyDTO {
    private String commandName;
    private String domainEntity;
    private String commandTimestamp;
    private String commandType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CommandData commandData;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CommandDataToll commandDataToll;


    public EventEntityBodyDTO(String commandName, String domainEntity, String commandTimestamp, String commandType, CommandDataToll commandData) {
        this.commandName = commandName;
        this.domainEntity = domainEntity;
        this.commandTimestamp = commandTimestamp;
        this.commandType = commandType;
        this.commandDataToll = commandData;
    }

    public EventEntityBodyDTO(String commandName, String domainEntity, String commandTimestamp, String commandType, CommandData commandData) {
        this.commandName = commandName;
        this.domainEntity = domainEntity;
        this.commandTimestamp = commandTimestamp;
        this.commandType = commandType;
        this.commandData = commandData;
    }
}