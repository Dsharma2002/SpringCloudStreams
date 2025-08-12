package com.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic-new", groupId = "my-group-rider")
    public void listenRiderLocation(RiderLocation location) {
        System.out.println("Received rider location: " + location.getRiderId() + " at " + location.getLatitude() + ", " + location.getLongitude());
    }

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void consume2(String message) {
        System.out.println("Consumer received message: " + message);
    }
}
