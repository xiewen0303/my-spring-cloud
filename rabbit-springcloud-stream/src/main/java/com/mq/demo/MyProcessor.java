package com.mq.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyProcessor {

    String INPUT = "my_input";
    @Input(INPUT)   //不设置参数，通道名称就默认为方法名。
    SubscribableChannel inputMsg();



    String OUTPUT = "my_output";
    @Output(OUTPUT)
    MessageChannel outputMsg();
}
