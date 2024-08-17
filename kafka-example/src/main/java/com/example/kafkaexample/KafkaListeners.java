package com.example.kafkaexample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "kafkaExample",
                    groupId = "testId"
    )
    void listener(String data) {
        System.out.println("Listener Received: " + data + " :D");
    }

}
