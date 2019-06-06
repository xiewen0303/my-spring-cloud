package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class GatewayConfig {

    /**
     * 发起 http://localhost:8080/get请求时，会跳到 http://localhost:8080/rout上去
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder result = builder.routes();
        result.route(predicateSpec -> predicateSpec
                .path("/get")
                .filters(new Function<GatewayFilterSpec, UriSpec>() {
                    @Override
                    public UriSpec apply(GatewayFilterSpec gatewayFilterSpec) {
                        return  gatewayFilterSpec.addRequestHeader("hello", "world");
                    }
                })
                .uri("http://localhost:8080/rout")
        );
        return result.build();
    }
}
