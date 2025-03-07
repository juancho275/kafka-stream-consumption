package co.com.spike.spring.cloud.stream.kafka_stream_consumption.general.utils;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class GenerateTimeStampUtil {

    private GenerateTimeStampUtil() {
    }

    private static final String PATTERN_TIME = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static String generateTimeStamp() {
        ZonedDateTime dateTimeMinusDays = ZonedDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_TIME);
        return dateTimeMinusDays.toLocalDateTime().atZone(ZoneOffset.UTC).format(formatter);
    }
}
