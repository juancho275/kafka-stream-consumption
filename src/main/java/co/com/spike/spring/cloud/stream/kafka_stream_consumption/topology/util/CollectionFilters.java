package co.com.spike.spring.cloud.stream.kafka_stream_consumption.topology.util;


import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto.JoinConsumptionMovements;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.MovementsCollectionsServices;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CollectionFilters {
    public static final Predicate<MovementsCollectionsServices> PROCESSED_AND_NOT_ADJUSTED =
            value -> "Y".equals(value.getSnProcesado()) && "N".equals(value.getSnAjustado());

    public static final Predicate<MovementsCollectionsServices> HAS_POSITIVE_CHARGE =
            value -> value.getVrCobro() > 0;

    public static final Predicate<MovementsCollectionsServices> VALID_STATE =
            value -> value.getCdEstado() == 1 || value.getCdEstado() == 0;

    public static final Predicate<MovementsCollectionsServices> VALID_MOVEMENT_TYPES =
            value -> value.getCdTipoMvto() == 0 || value.getCdTipoMvto() == 1;

    public static final Predicate<JoinConsumptionMovements> IS_ADJUSTMENT_VALID =
            joinConsumptionMovements -> joinConsumptionMovements.getMovementType() == 0 || joinConsumptionMovements.getMovementType() == 1 && joinConsumptionMovements.getAdjustmentChargeService() == 2;

}