package com.rabbit.fanout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
public class FanoutReceived {

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void  receive1(String msg){
        log.info("receive1 msg=====:{}",msg);
    }

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void  receive2(String msg){
        log.info("receive2 msg=====:{}",msg);
    }

    @RabbitListener(queues = "autoDeleteQueue")
    public void  autoDeleteQueue(String msg){
        log.info("receive msg=====:{}",msg);
    }
}
