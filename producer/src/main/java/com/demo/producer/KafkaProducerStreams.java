package com.demo.producer;

import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerStreams {

    @Bean
    public Supplier<RiderLocation> sendRiderLocation() {
        return () -> {
            RiderLocation riderLocation = new RiderLocation("rider#123", 12.97, 77.59);
            System.out.println("Sending RiderLocation: " + riderLocation.getRiderId());
            return riderLocation;
        };
    }

}
