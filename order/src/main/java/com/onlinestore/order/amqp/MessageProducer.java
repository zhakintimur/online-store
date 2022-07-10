package com.onlinestore.order.amqp;

import com.onlinestore.common.model.QueueDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static com.onlinestore.common.amqp.RabbitConst.CORE_EXCHANGE;
import static com.onlinestore.common.amqp.RabbitConst.ORDER_ROUTING_KEY;

@Component
@RequiredArgsConstructor
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public void send(QueueDto message) {
        rabbitTemplate.convertAndSend(CORE_EXCHANGE, ORDER_ROUTING_KEY, message);
    }
}
