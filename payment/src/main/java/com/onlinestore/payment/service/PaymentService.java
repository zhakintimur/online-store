package com.onlinestore.payment.service;

import com.onlinestore.common.model.QueueDto;
import com.onlinestore.payment.amqp.MessageProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final MessageProducer messageProducer;

    private static int counter = 0;

    @Scheduled(fixedDelay = 1500L)
    public void produce() {
        var dto = new QueueDto("New Payment #" + ++counter);
        messageProducer.send(dto);
//        System.out.println(dto);
    }

}
