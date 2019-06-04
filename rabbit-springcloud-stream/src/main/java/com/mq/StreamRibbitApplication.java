package com.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.mq.demo")
@SpringBootApplication
public class StreamRibbitApplication {

    public static void main(String[] args){
        SpringApplication.run(StreamRibbitApplication.class);
    }
}
