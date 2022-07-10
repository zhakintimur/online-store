package com.onlinestore.core.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.onlinestore.common.amqp.RabbitConst.*;

@Configuration
public class AmqpConfiguration {

    @Bean
    public Queue orderQueue() {
        return  new Queue(ORDER_QUEUE);
    }

    @Bean
    public Queue paymentQueue() {
        return  new Queue(PAYMENT_QUEUE);
    }

    @Bean
    public TopicExchange coreExchange() {
        return new TopicExchange(CORE_EXCHANGE);
    }

    @Bean
    public Binding orderBinding(Queue orderQueue, TopicExchange coreExchange) {
        return BindingBuilder
                .bind(orderQueue)
                .to(coreExchange)
                .with(ORDER_ROUTING_KEY);
    }

    @Bean
    public Binding paymentBinding(Queue paymentQueue, TopicExchange coreExchange) {
        return BindingBuilder
                .bind(paymentQueue)
                .to(coreExchange)
                .with(PAYMENT_ROUTING_KEY);
    }

    @Bean
    public Queue mailQueue() {
        return  new Queue(MAIL_QUEUE);
    }

    @Bean
    public TopicExchange mailExchange() {
        return new TopicExchange(MAIL_EXCHANGE);
    }

    @Bean
    public Binding mailBinding(Queue mailQueue, TopicExchange mailExchange) {
        return BindingBuilder
                .bind(mailQueue)
                .to(mailExchange)
                .with(MAIL_ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter() {
        return  new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return  template;
    }

}
