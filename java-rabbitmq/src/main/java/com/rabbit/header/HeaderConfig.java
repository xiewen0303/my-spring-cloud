package com.rabbit.header;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class HeaderConfig {

    @Bean
    public HeadersExchange exchange(){
        return new HeadersExchange("headersExchange");
    }

    @Bean
    public Queue queue(){
        return new Queue("headersQueue");
    }


    @Bean
    public Binding bindingQueue2Exchange(@Qualifier("queue") Queue queue,@Qualifier("exchange")HeadersExchange exchange){
        Map<String,Object> headKeys = new HashMap<>();
        headKeys.put("One","A");
        headKeys.put("Two","B");
        return BindingBuilder.bind(queue).to(exchange).whereAll(headKeys).match();
    }

//    @Bean
//    public Binding bindingQueue2Exchange1(@Qualifier("queue") Queue queue,@Qualifier("exchange")HeadersExchange exchange){
//        Map<String,Object> headKeys = new HashMap<>();
//        headKeys.put("One","A");
//        headKeys.put("Two","B");
//        return BindingBuilder.bind(queue).to(exchange).whereAny(headKeys).match();
//    }


    @Bean
    public Received received(){
        return new Received();
    }

    @Bean
    public Sender sender(){
        return new Sender();
    }
}
