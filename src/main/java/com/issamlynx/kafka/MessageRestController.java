package com.issamlynx.kafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageRestController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MessageRestController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String sendMessageToKafkaTopic(@RequestBody MessageRequest request) {
        // Envoyer le message au topic "issamevents"
        kafkaTemplate.send("issamevents", request.message());
        return "Message envoyé avec succès au topic 'issamevents'";
    }
}
