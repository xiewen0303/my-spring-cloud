package com.spring.cloud.servicezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;


/**
 * 共同点：@EnableDiscoveryClient和@EnableEurekaClient就是：都是能够让注册中心能够发现，扫描到改服务。
 * 不同点：@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心。
 */
@ComponentScan(basePackages = {"com.spring.cloud.zuulfilter"})
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class ServiceZuulApplication {

    public static void main(String[] args){
        SpringApplication.run(ServiceZuulApplication.class,args);
    }
}
