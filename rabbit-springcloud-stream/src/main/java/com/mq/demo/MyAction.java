package com.mq.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MyAction {

    @Resource
    private StreamOutput streamOutput;

    @RequestMapping(value = "/send",produces ={"text/html;charset=UTF-8"})
    public String test(String msg) {
        streamOutput.sendMessage(msg);
        return "OK";
    }
}
