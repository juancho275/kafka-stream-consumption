package co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.lang.NonNull;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JsonDeserializer<T> implements Deserializer<T>, ApplicationContextAware {

    private static final Logger LOGGER = LogManager.getLogger(JsonDeserializer.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    private Class<T> tClass;

    private static KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topics.deadLetter}")
    private static String deadLetterTopic;

    @Override
    public synchronized void setApplicationContext(@NonNull ApplicationContext applicationContext) {
        if (JsonDeserializer.kafkaTemplate == null) {
            JsonDeserializer.kafkaTemplate = applicationContext.getBean(KafkaTemplate.class);
            JsonDeserializer.deadLetterTopic = applicationContext.getEnvironment().getProperty("topics.deadLetter");
        }
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        tClass = (Class<T>) configs.get("JsonPOJOClass");
        if (tClass == null) {
            throw new IllegalArgumentException("JsonPOJOClass property is required");
        }
        LOGGER.info("KafkaTemplate and deadLetterTopic initialized: {}", kafkaTemplate != null && deadLetterTopic != null);
    }

    @Override
    public T deserialize(String topic, byte[] bytes) {
        if (kafkaTemplate == null) {
            throw new IllegalStateException("KafkaTemplate is not initialized");
        }

        LOGGER.info("KafkaTemplate available during deserialize: {}", kafkaTemplate != null);
        if (bytes == null) {
            LOGGER.warn("Null data received for deserialization");
            return null;
        }

        try {
            return objectMapper.readValue(bytes, tClass);
        } catch (Exception e) {
            LOGGER.error("Error deserializing data from topic: {}", topic, e);
            sendToDeadLetterTopic(topic, new String(bytes));
            throw new SerializationException("Error deserializing message", e);
        }
    }

    private void sendToDeadLetterTopic(String topic, String message) {
        LOGGER.info("KafkaTemplate available during sendToDeadLetterTopic: {}", kafkaTemplate != null);
        try {
            if (kafkaTemplate != null) {
                kafkaTemplate.send(new ProducerRecord<>(deadLetterTopic, topic,message));
            } else {
                LOGGER.error("KafkaTemplate is null, cannot send message to dead letter topic");
            }
        } catch (Exception e) {
            LOGGER.error("Error sending message to dead letter topic: {}", deadLetterTopic, e);
        }
    }
}