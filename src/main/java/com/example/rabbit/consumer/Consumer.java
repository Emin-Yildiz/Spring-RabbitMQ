package com.example.rabbit.consumer;

import com.example.rabbit.config.RabbitConfig;
import com.example.rabbit.entities.ProductStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = RabbitConfig.QUEUE) // kuyruğu dinler ve kuyrukta mesaj varsa alır ve mesajı siler.
    public void consumeMsg(ProductStatus productStatus){
        System.out.println("Message is coming from queue : " + productStatus);
    }
}
