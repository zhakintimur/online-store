package com.onlinestore.mailing.config;

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
    public Queue mailQueue() {
        return  new Queue(MAIL_QUEUE);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(MAIL_EXCHANGE);
    }

    @Bean
    public Binding mailBinding(Queue mailQueue, TopicExchange exchange) {
        return BindingBuilder
                .bind(mailQueue)
                .to(exchange)
                .with(MAIL_ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return  template;
    }

}
