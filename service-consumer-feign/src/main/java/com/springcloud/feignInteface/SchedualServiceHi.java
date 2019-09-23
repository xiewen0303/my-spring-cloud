package com.springcloud.feignInteface;

import com.springcloud.demo.service.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class,configuration = FeignFormConfiguration.class)
public interface SchedualServiceHi {

    @RequestMapping(value = "/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name, String orgCode);


    @RequestMapping(value = "/say",
            method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    String verify(Student student);

}
