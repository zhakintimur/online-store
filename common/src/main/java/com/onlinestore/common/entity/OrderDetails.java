package com.onlinestore.common.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderDetails {
    @Id
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Integer quantity;
}
