package co.com.spike.spring.cloud.stream.kafka_stream_consumption.serdes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;

public class JsonSerializer<T>  implements Serializer<T> {

    private static final Logger LOGGER = LogManager.getLogger(JsonSerializer.class);
    @Override
    public byte[] serialize(String topic, T data) {
        ObjectMapper mapper = new ObjectMapper();
        byte[] retVal = null;
        try{
            mapper.writeValueAsBytes(data);
            retVal = mapper.writeValueAsString(data).getBytes(StandardCharsets.UTF_8);
        } catch (JsonProcessingException e) {
            LOGGER.error("There was an error serializing object",e);
        }

        return retVal;
    }
}