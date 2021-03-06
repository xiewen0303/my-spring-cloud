package com.springcloud.demo;

import com.springcloud.feignInteface.SchedualServiceHi;
import com.springcloud.feignInteface.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {

    @Resource
    private SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/sayHi")
    public String sayHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name,"testHead");
    }

    @GetMapping(value = "/say")
    public String say(@RequestParam String name){
        return schedualServiceHi.verify(new Student(name,1));
    }
}
