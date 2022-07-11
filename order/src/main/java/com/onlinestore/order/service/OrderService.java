package com.onlinestore.order.service;

import com.onlinestore.common.entity.OrderDetails;
import com.onlinestore.common.model.QueueDto;
import com.onlinestore.order.amqp.MessageProducer;

import com.onlinestore.common.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final MessageProducer messageProducer;

    private static int counter = 0;

//    @Scheduled(fixedDelay = 1500L)
    public Order create(List<OrderDetails> orderDetailsList) {
        var order = orderDetailsList.get(0).getOrder();
        var dto = new QueueDto("New Order #" + ++counter);
        messageProducer.send(dto);
        return order;
    }

}
