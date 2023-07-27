package com.example.rabbit.publisher;

import com.example.rabbit.config.RabbitConfig;
import com.example.rabbit.entities.Product;
import com.example.rabbit.entities.ProductStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    private RabbitTemplate rabbitTemplate;

    public OrderPublisher(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/{companyName}")
    public String bookOrder(@RequestBody Product product, @PathVariable String companyName){
        product.setId(UUID.randomUUID().toString());
        ProductStatus productStatus = new ProductStatus(product, "PRODUCT succes in " + companyName);
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE,RabbitConfig.ROUTING_KEY, productStatus); // kuyruğa mesaj gönderir.
        return "Message send is success";
    }
}
