package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixConfig {

    /**
     * 只要host已xxxx.hystrix.com的,都会采用下面route配置。（这里的host可以在header中设置 HOST=aaa.hystrix.com）
     * 如果服务不存在,则直接跳转到fallback执行
     * uri指定的地址可以访问成功，那么就会跳转到对应的uri地址上执行
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")))
                        .uri("http://localhost:8960"))
                .build();
    }

}
