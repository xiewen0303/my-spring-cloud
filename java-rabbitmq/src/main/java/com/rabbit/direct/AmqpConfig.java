package com.rabbit.direct;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {

    private  static  final String QUEUE_NAME = "hello";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public Received received() {
        return  new Received();
    }

    @Bean
    public Sender sender() {
        return new Sender();
    }
}
