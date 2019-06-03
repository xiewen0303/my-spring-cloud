package com.rabbit.header;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.UnsupportedEncodingException;

@Slf4j
public class Received {

    @RabbitListener(queues = "headersQueue")
    public void receivedHeaderMsg(Message msg) throws UnsupportedEncodingException{
        MessageProperties messageProperties = msg.getMessageProperties();

        String contentType = messageProperties.getContentType();

        log.info("Receive-Headers:{}",new String(msg.getBody(),contentType));
    }
}
