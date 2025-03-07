package co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommandData {
    private long date;
    private String transactionId;
    private Double value;
    private String movementDescription;
    private String walletId;
    private String transactionType;
    private String flyKey;
    private int attentionPointId;
    private int consumptionType;
    private String pocketId;
    private String pocketName;
    private String currencyCode;
    private String flyKeyType;
}