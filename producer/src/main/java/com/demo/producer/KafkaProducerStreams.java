package com.demo.producer;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.util.MimeTypeUtils;

@Configuration
public class KafkaProducerStreams {

    @Bean
    public Supplier<RiderLocation> sendRiderLocation() {
        Random random = new Random();
        return () -> {
            String riderId = "rider#" + random.nextInt(1000);
            RiderLocation riderLocation = new RiderLocation(riderId, 12.97, 77.59);
            System.out.println("Sending RiderLocation: " + riderLocation.getRiderId());
            return riderLocation;
        };
    }

    @Bean
    public Supplier<Message<String>> sendRiderStatus() {
        Random random = new Random();
        return () -> {
            String riderId = "rider#" + random.nextInt(1000);
            String status = random.nextBoolean() ? "Rider on way" : "Rider completed delivery";
            System.out.println("Sending Status: " + riderId + " - " + status);
            return MessageBuilder.withPayload(riderId + " - " + status)
                    .setHeader(KafkaHeaders.KEY, riderId.getBytes())
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_PLAIN)
                    .build();
        };
    }

}
