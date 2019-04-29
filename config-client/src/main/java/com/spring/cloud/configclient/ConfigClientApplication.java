package com.spring.cloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class ConfigClientApplication {

    public static void main(String[] args){
        SpringApplication.run(ConfigClientApplication.class,args);
    }

    @Value("${name}")
    String name;

    @Value("${email}")
    String email;

    @RequestMapping(value = "/configInfo")
    public String hi(){
       return MessageFormat.format("name:{0},email:{1}",name,email);
    }
}