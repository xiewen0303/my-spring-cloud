package com.gateway.action;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class GatewayAction {

    @RequestMapping(value = "/rout")
    public String routRequest(@RequestHeader("hello") String data){
        log.info("coming routRequest method,data={}",data);
        return "rout ok";
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        log.info("coming fallback...");
        return Mono.just("fallback");
    }

    @RequestMapping(value = "/data")
    public String dataRequest(){
        log.info("coming dataRequest method");
        return "data request ok";
    }
}
