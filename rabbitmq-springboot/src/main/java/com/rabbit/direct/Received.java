package com.rabbit.direct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j

public class Received {

    @RabbitListener(queues = "hello")
    public void  receive(String msg){
        log.info("receive msg=====:{}",msg);
    }

}
