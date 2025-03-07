package co.com.spike.spring.cloud.stream.kafka_stream_consumption.topology.util;


import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.MovementsAttentionsPointsConsultation;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.MovementsCollectionsServices;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Predicate;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MovementFilters {

    public static final Predicate<MovementsAttentionsPointsConsultation> IS_VALID_MOVEMENT_ATTENTION =
            value -> value != null &&
                    "Y".equalsIgnoreCase(value.getEsProcesado()) &&
                    "N".equalsIgnoreCase(value.getEsAjustado()) &&
                    value.getValorPagado() > 0 &&
                    value.getIdTipoMovimiento() == 2;

    public static final Predicate<MovementsCollectionsServices> IS_VALID_MOVEMENT_COLLECTION =
            value -> value != null &&
                    "Y".equalsIgnoreCase(value.getSnProcesado()) &&
                    "N".equalsIgnoreCase(value.getSnAjustado()) &&
                    value.getVrCobro() > 0 &&
                    (value.getCdEstado() == 1 || value.getCdEstado() == 0) &&
                    value.getCdTipoMvto() == 1;
}