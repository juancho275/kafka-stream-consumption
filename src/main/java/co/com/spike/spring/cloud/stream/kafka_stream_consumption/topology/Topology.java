package co.com.spike.spring.cloud.stream.kafka_stream_consumption.topology;

import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto.JoinConsumptionMovements;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.AdjustmentFlypass;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.AttentionPoint;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.MovementsAttentionsPointsConsultation;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.Vehicles;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.topology.util.ConsultationFilters;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.GlobalKTable;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.beans.factory.annotation.Qualifier;


import java.util.function.Function;

@Slf4j
@Configuration
public class Topology {


    @Bean
    public Function<KStream<String, MovementsAttentionsPointsConsultation>,
            KStream<String, JoinConsumptionMovements>> process(
            @Qualifier("vehicleStore") GlobalKTable<String, Vehicles> vehiclesGlobalKTable,
            @Qualifier("attentionPointStore") GlobalKTable<String, AttentionPoint> attentionPointGlobalKTable,
            @Qualifier("adjustmentFlypassStore") GlobalKTable<String, AdjustmentFlypass> adjustmentFlypassGlobalKTable) {
        System.setProperty("kafka.streams.preserve.permission", "true");
        return kStream -> kStream
                .filter((key, value) -> {
                    log.info("entra al filtro");
                    boolean isValid = value != null
                            && ConsultationFilters.PROCESSED_AND_NOT_ADJUSTED.test(value)
                            && ConsultationFilters.HAS_POSITIVE_PAYMENT.test(value)
                            && ConsultationFilters.VALID_MOVEMENT_TYPES.test(value);

                    if (!isValid) {
                        log.warn("Filtrado movimiento inválido: key={}, value={}", key, value);
                    }
                    return isValid;
                })
                .peek((key, value) -> log.info("Procesando key={}, idVehiculo={}", key, value.getIdVehiculo()))

                // Join con vehicleStore
                .join(vehiclesGlobalKTable,
                        (key, value) -> {
                            String vehicleId = value.getIdVehiculo();
                            log.info("Buscando vehículo: key={}, vehicleId={}", key, vehicleId);
                            return vehicleId;
                        },
                        (movement, vehicle) -> {
                            if (vehicle == null) {
                                log.warn("Vehículo no encontrado para id={}", movement.getIdVehiculo());
                                return null; // Evita joins con datos nulos
                            }
                            return JoinConsumptionMovements.builder()
                                    .transactionId(movement.getIdNumeroTransaccion())
                                    .transactionAmount(movement.getValorPagado())
                                    .userId(vehicle.getUserId())
                                    .plate(vehicle.getPlate())
                                    .attentionPointId(Integer.valueOf(movement.getIdPuntoAtencion()))
                                    .adjustmentType(Integer.valueOf(movement.getIdAjusteFlypass()))
                                    .movementType(movement.getIdTipoMovimiento())
                                    .build();
                        }
                )
                .filter((key, joinConsumptionMovements) -> joinConsumptionMovements != null)

                // Join con attentionPointStore
                .join(attentionPointGlobalKTable,
                        (key, joinConsumptionMovements) -> {
                            String attentionPointId = String.valueOf(joinConsumptionMovements.getAttentionPointId());
                            log.info("Buscando punto de atención: key={}, attentionPointId={}", key, attentionPointId);
                            return attentionPointId;
                        },
                        (joinConsumptionMovements, attentionPoint) -> {
                            if (attentionPoint == null) {
                                log.warn("Punto de atención no encontrado para id={}", joinConsumptionMovements.getAttentionPointId());
                                return joinConsumptionMovements;
                            }
                            joinConsumptionMovements.setAttentionPointId(attentionPoint.getAttentionPointId());
                            return joinConsumptionMovements;
                        }
                )

                // Left Join con adjustmentFlypassStore
                .leftJoin(adjustmentFlypassGlobalKTable,
                        (key, joinConsumptionMovements) -> {
                            String adjustmentTypeId = String.valueOf(joinConsumptionMovements.getAdjustmentType());
                            log.info("Buscando ajuste: key={}, adjustmentTypeId={}", key, adjustmentTypeId);
                            return adjustmentTypeId;
                        },
                        (joinConsumptionMovements, adjustmentFlypass) -> {
                            if (adjustmentFlypass != null) {
                                joinConsumptionMovements.setAdjustmentType(adjustmentFlypass.getCdTipoAjuste());
                            } else {
                                log.warn("Ajuste no encontrado para id={}", joinConsumptionMovements.getAdjustmentType());
                            }
                            return joinConsumptionMovements;
                        }
                )

                // Filtra solo movimientos con ajustes válidos
                .filter((key, joinConsumptionMovements) -> {
                    boolean isValid = ConsultationFilters.IS_ADJUSTMENT_VALID.test(joinConsumptionMovements);
                    if (!isValid) {
                        log.warn("Movimiento con ajuste inválido: key={}, value={}", key, joinConsumptionMovements);
                    }
                    return isValid;
                });
    }
}

