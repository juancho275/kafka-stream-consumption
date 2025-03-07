package co.com.spike.spring.cloud.stream.kafka_stream_consumption.topology.util;

import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto.JoinConsumptionMovements;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.MovementsAttentionsPointsConsultation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Predicate;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConsultationFilters {
    public static final Predicate<MovementsAttentionsPointsConsultation> PROCESSED_AND_NOT_ADJUSTED =
            value -> "Y".equals(value.getEsProcesado()) && "N".equals(value.getEsAjustado());

    public static final Predicate<MovementsAttentionsPointsConsultation> HAS_POSITIVE_PAYMENT =
            value -> value.getValorPagado() > 0;

    public static final Predicate<MovementsAttentionsPointsConsultation> VALID_MOVEMENT_TYPES =
            value -> value.getIdTipoMovimiento() == 1 || value.getIdTipoMovimiento() == 2;

    public static final Predicate<JoinConsumptionMovements> IS_ADJUSTMENT_VALID =
            joinConsumptionMovements -> joinConsumptionMovements.getMovementType() == 1 || joinConsumptionMovements.getMovementType() == 2 && joinConsumptionMovements.getAdjustmentType() != null && joinConsumptionMovements.getAdjustmentType() == 2;
}
