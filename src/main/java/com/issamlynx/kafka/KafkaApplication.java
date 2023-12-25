package com.issamlynx.kafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	@Bean
	public CommandLineRunner produceMessageRunner(KafkaTemplate<String,String> kafkaTemplate) {
		return args -> {
			// Envoyer un message au topic "issamlynx"
			String message = "Hello, Kafka! This is a message from Spring Boot.";
			kafkaTemplate.send("IssamLynx", message);

			System.out.println("Message envoyé avec succès au topic 'IssamLynx'");
		};
	}

}
