package com.rabbit.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
public class TopicReceived {

    @RabbitListener(queues = "my.message")
    public void receivedMessage(String message){
        log.info("recevied message:{}",message);
    }

    @RabbitListener(queues = "topic.notes")
    public void receivedNotes(String message){
        log.info("recevied  notes :{}",message);
    }
}
