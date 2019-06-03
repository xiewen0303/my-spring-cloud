package com.rabbit.direct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

@Slf4j
public class Sender {

    @Resource
    private RabbitTemplate template;

    @Resource
    private Queue queue;

    @Scheduled(fixedDelay = 1000,initialDelay = 500)
    public void  send(){
        String message = "Hello world!";
        template.convertAndSend(queue.getName(),message);
        log.info("sent {} ",message);
    }

}
