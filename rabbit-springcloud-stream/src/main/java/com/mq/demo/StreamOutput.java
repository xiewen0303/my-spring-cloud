package com.mq.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;


import javax.annotation.Resource;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@Slf4j
@EnableBinding(MyProcessor.class)
public class StreamOutput {

    @Resource
    private MyProcessor channel;

    public void sendMessage(String msg){
        Message message = MessageBuilder.withPayload(msg).build();
        channel.outputMsg().send(message);
        log.info("send message: {}",message.getPayload());
    }
}
