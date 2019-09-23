package com.springcloud.demo.service;

import com.springcloud.feignInteface.SchedualServiceHi;
import com.springcloud.feignInteface.Student;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name,String orgCode) {
        return "sorry "+name;
    }

    @Override
    public String verify(Student student){
        return "sorry verify";
    }
}
