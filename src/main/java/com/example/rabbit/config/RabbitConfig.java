package com.example.rabbit.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE = "rabbit_queue";
    public static final String EXCHANGE = "rabbit_exchange";
    public static final String ROUTING_KEY = "rabbit_routingKey";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);
    }

    @Bean // kuyruk ve exchange arasında routing ile bağlantı oluşturuldu. Bu metodu çoğaltarak birden çok bağlantı oluşturabiliriz.
    public Binding binding(Queue queue, TopicExchange topicExchange){
        return BindingBuilder
                .bind(queue)
                .to(topicExchange)
                .with(ROUTING_KEY);
    }

//    // fanoutexchange yapısı, mesajları direkt olarak hedef kuyruklara göndermek yerine, tüm kuyruklara aynı mesajları gönderir.
//    @Bean
//    public FanoutExchange fanoutExchange() {
//        return new FanoutExchange("exchange.fanout");
//    }

//    // Aynı routingKey kullanan queue'lara aynı mesaja gönderir.
//    @Bean
//    DirectExchange direktExchange() {
//        return new DirectExchange("exchange.direct");
//    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}


