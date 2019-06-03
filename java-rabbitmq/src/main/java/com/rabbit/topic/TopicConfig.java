package com.rabbit.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

    @Bean(name = "message")
    public Queue queueMessage(){
        return new Queue("my.message");
    }

    @Bean(name = "notes")
    public Queue queueNotes(){
        return new Queue("topic.notes");
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("topicExchange");
    }

    /**
     *TODO   "." 表示分隔路由键，（其中路由键可以试任何字符串）
     *TODO   "#" 表示0个或多个路由键
     *TODO   "*" 表示1个路由键
     * 这里注意了，如果之前运行绑定过routingKey,是需要在界面删除的。
     */
    @Bean
    public Binding bindingQueue2Exchange(@Qualifier("message") Queue queue,@Qualifier("exchange")TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("#.topic");
    }

    @Bean
    public Binding bindingQueues2Exchange(@Qualifier("notes") Queue queue,@Qualifier("exchange")TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("*.orange.*");
    }

    @Bean
    public TopicSender topicSender(){
        return new TopicSender();
    }

    @Bean
    public TopicReceived topicReceived(){
        return new TopicReceived();
    }
}
