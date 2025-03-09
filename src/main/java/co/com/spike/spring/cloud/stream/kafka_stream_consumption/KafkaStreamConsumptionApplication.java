package co.com.spike.spring.cloud.stream.kafka_stream_consumption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication

public class KafkaStreamConsumptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaStreamConsumptionApplication.class, args);
	}

}
