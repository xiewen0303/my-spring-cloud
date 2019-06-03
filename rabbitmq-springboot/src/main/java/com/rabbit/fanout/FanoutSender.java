package com.rabbit.fanout;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

@Slf4j
public class FanoutSender {

    @Resource
        private RabbitTemplate template;

        @Resource
        private FanoutExchange fanout;

        private int i = 0;

        @Scheduled(fixedDelay = 1000,initialDelay = 500)
        public void  send() {
        String message = "message" + ++i;
        template.convertAndSend(fanout.getName(),"",message);
        log.info("sent {} ",message);
    }

}
