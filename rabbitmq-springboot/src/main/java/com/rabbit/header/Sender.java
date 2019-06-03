package com.rabbit.header;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

@Slf4j
public class Sender {

    @Resource
    private RabbitTemplate rabbitTemplate;

    private int i = 0;

    @Scheduled(initialDelay = 1000,fixedDelay = 500)
    public void send(){
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
        messageProperties.setContentType("UTF-8");
        messageProperties.setHeader("One","A");
        messageProperties.setHeader("Two","B");

        Message message = new Message("我们测试数据".getBytes(),messageProperties);

        String msg = "send header msg" + ++i;
        rabbitTemplate.convertAndSend("headersExchange",null,message);
        log.info("send header msg,{}",msg);
    }
}
