package co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class JoinConsumptionMovements {
    private String transactionId;
    private Double transactionAmount;
    private Integer userId;
    private String plate;
    private Integer attentionPointId;
    private Integer movementType;
    private Integer adjustmentType;
    private Long adjustmentChargeService;
}
