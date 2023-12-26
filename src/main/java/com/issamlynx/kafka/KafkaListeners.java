package com.issamlynx.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "issamevents", groupId = "group-id")
     void listen(String message) {
        System.out.println("Message reçu : " + message);
    }
}
