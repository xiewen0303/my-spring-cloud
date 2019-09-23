package com.spring.cloud.myeurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
@RestController
public class MyEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyEurekaClientApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	public String home(@RequestParam(value = "name", defaultValue = "forezp") String name, @RequestHeader String orgCode) {
		System.out.println("coming、、、"+orgCode);
		return "hi " + name + " ,i am from port:" + port;
	}

	@RequestMapping("/say")
	public String verify(Student student){
		System.out.println(student.getName());
		return "ok";
	}
}
