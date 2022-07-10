package com.onlinestore.order.controller;

import com.onlinestore.common.entity.OrderDetails;
import com.onlinestore.order.service.OrderService;
import com.onlinestore.common.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {

    private final OrderService orderService;

    @PostMapping("/")
    public Order create(@RequestBody List<OrderDetails> orderDetailsList) {
        return orderService.create(orderDetailsList);
    }

}
