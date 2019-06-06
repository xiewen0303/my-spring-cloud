package com.web.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class WebDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebDemoApplication.class);
    }

    @RequestMapping(value = "testDemo")
    public String testDemo(){
        log.info("coming testDemo ...");
       return "coming testDemo";
    }

    @RequestMapping(value = "testOther")
    public String testOther(){
        log.info("coming testOther ...");
        return "coming testOther";
    }
}
