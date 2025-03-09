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
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.stream.binder.kafka.streams.properties.KafkaStreamsBinderConfigurationProperties;
import org.springframework.cloud.stream.config.BindingServiceProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.kafka.config.KafkaStreamsConfiguration;


import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

@Slf4j
@Configuration
public class Topology {

    @Bean
    public Function<KStream<String, MovementsAttentionsPointsConsultation>,
            Function<GlobalKTable<String, Vehicles>,
                    Function<GlobalKTable<String, AttentionPoint>,
                            Function<GlobalKTable<String, AdjustmentFlypass>, KStream<String, JoinConsumptionMovements>>>>> process() {

        return movementsStream -> (vehiclesTable -> (attentionPointTable -> (adjustmentFlypassTable ->

                movementsStream
                        .filter((key, value) -> {
                            boolean isValid = value != null
                                    && ConsultationFilters.PROCESSED_AND_NOT_ADJUSTED.test(value)
                                    && ConsultationFilters.HAS_POSITIVE_PAYMENT.test(value)
                                    && ConsultationFilters.VALID_MOVEMENT_TYPES.test(value);

                            if (!isValid) log.warn("❌ Movimiento inválido: key={}, value={}", key, value);
                            return isValid;
                        })
                        .peek((key, value) -> log.info("🔄 Procesando Movimiento key={}, idVehiculo={}", key, value.getIdVehiculo()))

                        // Left Join con Vehicles
                        .leftJoin(vehiclesTable,
                                (key, value) -> value.getIdVehiculo(),
                                (movement, vehicle) -> {
                                    if (vehicle == null) {
                                        log.warn("🚫 Vehículo NO encontrado: id={}", movement.getIdVehiculo());
                                        return null;
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

                        // Left Join con AttentionPoint
                        .leftJoin(attentionPointTable,
                                (key, joinConsumptionMovements) -> String.valueOf(joinConsumptionMovements.getAttentionPointId()),
                                (joinConsumptionMovements, attentionPoint) -> {
                                    if (attentionPoint == null) {
                                        log.warn("🚫 Punto de Atención NO encontrado: id={}", joinConsumptionMovements.getAttentionPointId());
                                        return joinConsumptionMovements;
                                    }
                                    return joinConsumptionMovements;
                                }
                        )

                        // Left Join con AdjustmentFlypass
                        .leftJoin(adjustmentFlypassTable,
                                (key, joinConsumptionMovements) -> String.valueOf(joinConsumptionMovements.getAdjustmentType()),
                                (joinConsumptionMovements, adjustmentFlypass) -> {
                                    if (adjustmentFlypass != null) {
                                        joinConsumptionMovements.setAdjustmentType(adjustmentFlypass.getCdTipoAjuste());
                                    } else {
                                        log.warn("🚫 Ajuste NO encontrado para id={}", joinConsumptionMovements.getAdjustmentType());
                                    }
                                    return joinConsumptionMovements;
                                }
                        )

                        // Filtra solo ajustes válidos
                        .filter((key, joinConsumptionMovements) -> {
                            boolean isValid = ConsultationFilters.IS_ADJUSTMENT_VALID.test(joinConsumptionMovements);
                            if (!isValid) log.warn("⚠️ Ajuste inválido: key={}, value={}", key, joinConsumptionMovements);
                            return isValid;
                        })
        )));
    }
}