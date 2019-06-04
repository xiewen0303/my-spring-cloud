package com.mq.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;


@Slf4j
@EnableBinding(MyProcessor.class)
public class StreamInput {

    @StreamListener(MyProcessor.INPUT)
    public void recevice1LogMessage(Message<String> msg) {
        log.info("recevice1 message={}",msg.getPayload());
    }


//    @StreamListener(MyProcessor.INPUT)
//    public void recevice2LogMessage(Message<String> msg) {
//        log.info("recevice2 message={}",msg.getPayload());
//    }
}
