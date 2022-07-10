package com.onlinestore.core.amqp;

import com.onlinestore.common.model.QueueDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static com.onlinestore.common.amqp.RabbitConst.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageConsumer {

    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = ORDER_QUEUE)
    public void ordersListener(QueueDto message) {
        System.out.println(message);
        var notificationMessage = new QueueDto("New Order Notification #" + message.getMessage().split("#")[1]);
        rabbitTemplate.convertAndSend(MAIL_EXCHANGE, MAIL_ROUTING_KEY, notificationMessage);
    }

    @RabbitListener(queues = PAYMENT_QUEUE)
    public void paymentsListener(QueueDto message) {
        System.out.println(message);
        var notificationMessage = new QueueDto("New Payment Notification #" + message.getMessage().split("#")[1]);
        rabbitTemplate.convertAndSend(MAIL_EXCHANGE, MAIL_ROUTING_KEY, notificationMessage);
    }

}
