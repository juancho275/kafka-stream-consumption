package co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommandDataToll {
    @JsonProperty("date")
    private long date;
    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("value")
    private Double value;
    @JsonProperty("movementDescription")
    private String movementDescription;
    @JsonProperty("walletId")
    private Integer walletId;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("transactionType")
    private String transactionType;
    @JsonProperty("pocketId")
    private String pocketId;
    @JsonProperty("currencyCode")
    private String currencyCode;
    @JsonProperty("pocketName")
    private String pocketName;
    @JsonProperty("adjustmentType")
    private Integer adjustmentType;
}
