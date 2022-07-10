package com.onlinestore.mailing.amqp;

import com.onlinestore.common.model.QueueDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.onlinestore.common.amqp.RabbitConst.*;

@Slf4j
@Component
public class MessageConsumer {
    @RabbitListener(queues = MAIL_QUEUE)
    public void ordersListener(QueueDto message) {
        System.out.println(message);
    }
}
