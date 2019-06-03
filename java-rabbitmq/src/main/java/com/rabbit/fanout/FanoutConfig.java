package com.rabbit.fanout;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;

@Configuration
public class FanoutConfig {

    @Bean
    public FanoutExchange fanout(){
        return new FanoutExchange("tut.fanout");
    }

    @Bean(name = "autoDeleteQueue1")
    public Queue autoDeleteQueue1(){
        return new AnonymousQueue();
    }

    @Bean(name = "autoDeleteQueue2")
    public Queue autoDeleteQueue2() {
//      AnonymousQueue:这个类是代表一个匿名的、不耐用的、独占的、自动删除的队列
        return new AnonymousQueue();
    }

    @Bean
    public Queue autoDeleteQueue(){
        return new Queue("autoDeleteQueue");
    }

    @Bean
    public FanoutReceived fanoutReceived(){
        return new FanoutReceived();
    }

    @Bean
    public FanoutSender fanoutSender(){
        return new FanoutSender();
    }

    @Bean
    public Binding binding1(@Qualifier("fanout") FanoutExchange fanout, @Qualifier("autoDeleteQueue1") Queue queue){
        return BindingBuilder.bind(queue).to(fanout);
    }

    @Bean
    public Binding binding2(@Qualifier("fanout") FanoutExchange fanout, @Qualifier("autoDeleteQueue2") Queue queue){
        return BindingBuilder.bind(queue).to(fanout);
    }

    @Bean
    public Binding binding3(@Qualifier("fanout") FanoutExchange fanout, @Qualifier("autoDeleteQueue") Queue queue){
        return BindingBuilder.bind(queue).to(fanout);
    }
}
