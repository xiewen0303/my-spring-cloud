package com.rabbit.demo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Received {

    private final static String QUEUE_NAME="hello";

    public static void main(String[] args) throws Exception {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("10.0.0.201");
        connectionFactory.setPassword("rabbit");
        connectionFactory.setUsername("rabbit");
        Connection conn = connectionFactory.newConnection();

        Channel channel = conn.createChannel();


        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.printf("message info: %s",message);
            }
        };

        channel.basicConsume(QUEUE_NAME,true,consumer);
    }
}
