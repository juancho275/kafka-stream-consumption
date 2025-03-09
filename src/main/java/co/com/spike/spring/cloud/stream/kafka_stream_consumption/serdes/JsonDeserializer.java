package co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class JsonDeserializer<T> implements Deserializer<T> {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private Class<T> clazz;

    // 🔹 Constructor vacío necesario para Spring
    public JsonDeserializer() {
    }

    // 🔹 Constructor con clase (para uso manual)
    public JsonDeserializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // Obtener la clase del mapa de configuración si no se ha pasado antes
        if (configs.containsKey("JsonPOJOClass")) {
            this.clazz = (Class<T>) configs.get("JsonPOJOClass");
        }
    }

    @Override
    public T deserialize(String topic, byte[] data) {
        try {
            if (data == null || clazz == null) {
                return null;
            }
            return objectMapper.readValue(data, clazz);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializando mensaje de Kafka para la clase: " + clazz.getSimpleName(), e);
        }
    }

    @Override
    public void close() {
        // No es necesario cerrar nada
    }
}