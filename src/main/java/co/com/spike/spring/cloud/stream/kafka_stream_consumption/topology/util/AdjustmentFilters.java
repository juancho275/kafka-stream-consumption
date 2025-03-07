package co.com.spike.spring.cloud.stream.kafka_stream_consumption.topology.util;


import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto.JoinConsumptionAdjustments;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdjustmentFilters {

    public static final Predicate<JoinConsumptionAdjustments> HAS_VALID_ADJUSTMENT =
            value -> value.getAdjustmentType() != null &&
                    value.getAdjustmentType() != 2;

    public static final Predicate<JoinConsumptionAdjustments> HAS_VALID_SERVICE_CHARGE_ADJUSTMENT =
            value -> value != null &&
                    value.getAdjustmentType()!= null &&
                    value.getAdjustmentType() != 2;
}