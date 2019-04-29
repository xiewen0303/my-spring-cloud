package com.spring.cloud.demo.controller;

import com.spring.cloud.demo.service.RestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MyController {

    @Resource
    RestService restService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return restService.hiService( name );
    }
}
