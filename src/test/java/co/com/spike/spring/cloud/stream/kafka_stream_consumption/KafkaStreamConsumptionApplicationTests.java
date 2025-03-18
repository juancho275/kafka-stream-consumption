package co.com.spike.spring.cloud.stream.kafka_stream_consumption;

import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.eventdto.JoinConsumptionMovements;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.AdjustmentFlypass;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.AttentionPoint;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.MovementsAttentionsPointsConsultation;
import co.com.spike.spring.cloud.stream.kafka_stream_consumption.dto.streamdto.Vehicles;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.EnableTestBinder;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.web.reactive.server.JsonPathAssertions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@EnableTestBinder
class KafkaStreamConsumptionApplicationTests {


    @Autowired
    private InputDestination input;

    @Autowired
    private OutputDestination output;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testKafkaStreamProcessing() throws Exception {
        // Crear objeto de entrada (Movimiento de Consulta)
        MovementsAttentionsPointsConsultation movement = new MovementsAttentionsPointsConsultation();
        movement.setIdVehiculo("V123");
        movement.setIdNumeroTransaccion("TX001");
        movement.setValorPagado(5000.0);
        movement.setIdPuntoAtencion("P456");
        movement.setIdAjusteFlypass("A789");
        movement.setIdTipoMovimiento(1);

        // Serializar y enviar mensaje de entrada
        String key = "test-key";
        String movementJson = objectMapper.writeValueAsString(movement);
        input.send(MessageBuilder.withPayload(movementJson).setHeader("key", key).build(), "process-in-0");

        // Simular GlobalKTable: Vehicles
        Vehicles vehicle = new Vehicles();
        vehicle.setUserId(1);
        vehicle.setPlate("ABC123");
        String vehicleJson = objectMapper.writeValueAsString(vehicle);
        input.send(MessageBuilder.withPayload(vehicleJson).setHeader("key", "V123").build(), "process-in-1");

        // Simular GlobalKTable: AttentionPoint
        AttentionPoint attentionPoint = new AttentionPoint();
        String attentionPointJson = objectMapper.writeValueAsString(attentionPoint);
        input.send(MessageBuilder.withPayload(attentionPointJson).setHeader("key", "P456").build(), "process-in-2");

        // Simular GlobalKTable: AdjustmentFlypass
        AdjustmentFlypass adjustmentFlypass = new AdjustmentFlypass();
        adjustmentFlypass.setCdTipoAjuste(2);
        String adjustmentJson = objectMapper.writeValueAsString(adjustmentFlypass);
        input.send(MessageBuilder.withPayload(adjustmentJson).setHeader("key", "A789").build(), "process-in-3");

        // Recuperar el mensaje procesado
        Message<byte[]> outputMessage = output.receive(5000, "process-out-0");

        // Deserializar y verificar la salida
        assertThat(outputMessage).isNotNull();
        String outputJson = new String(outputMessage.getPayload());
        JoinConsumptionMovements result = objectMapper.readValue(outputJson, JoinConsumptionMovements.class);

        // Validar que la salida tiene los datos correctos
        assertThat(result.getTransactionId()).isEqualTo("TX001");
        assertThat(result.getTransactionAmount()).isEqualTo(5000);
        assertThat(result.getUserId()).isEqualTo("U001");
        assertThat(result.getPlate()).isEqualTo("ABC123");
    }
}
