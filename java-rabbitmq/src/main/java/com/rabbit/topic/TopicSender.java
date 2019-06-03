package com.rabbit.topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

@Slf4j
public class TopicSender {

    @Resource
    private RabbitTemplate amqpTemplate;

    private int i = 0;

//    @Scheduled(initialDelay = 500,fixedDelay = 500)
//    public void sendMessage(){
//        String msg = "send message"+ ++i;
//        amqpTemplate.convertAndSend("topicExchange","topic.ak.df.jei.bbb",msg);
//        log.info("sent message {}",msg);
//    }
//
    @Scheduled(initialDelay = 500,fixedDelay = 1000)
    public void sendMessage1(){
        String msg = "send message"+ ++i;
        amqpTemplate.convertAndSend("topicExchange","data.orange.val",msg);
        log.info("sent message notes {}",msg);
    }

    @Scheduled(initialDelay = 500,fixedDelay = 1000)
    public void sendMessage2(){
        String msg = "send message"+ ++i;
        amqpTemplate.convertAndSend("topicExchange","aaa.bbb.topic",msg);
        log.info("sent message1 {}",msg);
    }
}
