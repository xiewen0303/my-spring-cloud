package com.spring.cloud.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class RestService {

    @Resource
    RestTemplate restTemplate;

    public String hiService(String name){
        return restTemplate.getForObject("http://service-hi/hi?name="+name,String.class);
    }
}
