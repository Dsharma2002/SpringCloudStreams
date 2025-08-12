package com.demo.consumer;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConsumerNew {

    @Bean
    public Consumer<RiderLocation> processRiderLocation() {
        return (RiderLocation location) -> {
            System.out.println("Received rider location: " + location.getRiderId() + " at " + location.getLatitude() + ", " + location.getLongitude());
        };
    }

    @Bean
    public Consumer<String> processRiderStatus() {
        return (status) -> {
            System.out.println("Received rider status: " + status);
        };
    }
}
