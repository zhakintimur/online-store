package com.onlinestore.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "order_date")
    private Instant orderDate;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
