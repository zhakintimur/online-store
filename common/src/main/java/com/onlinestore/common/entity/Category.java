package com.onlinestore.common.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Category {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
}
