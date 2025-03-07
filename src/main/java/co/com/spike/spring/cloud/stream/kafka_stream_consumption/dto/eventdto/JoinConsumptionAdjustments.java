package co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class JoinConsumptionAdjustments {
    private String transactionId;
    private double valuePaidOrCharged;
    private Integer userId;
    private String pointDisplayName;
    private Integer pointServiceId;
    private Integer adjustmentType;
    private String adjustmentFlypassId;
    private Boolean isCharged;

    public int calculateAdjustmentType() {
        if (valuePaidOrCharged > 0
                && adjustmentType == 1) {
            return 2;
        } else if (adjustmentType == 3) {
            return 1;
        } else {
            return 0;
        }
    }
}
