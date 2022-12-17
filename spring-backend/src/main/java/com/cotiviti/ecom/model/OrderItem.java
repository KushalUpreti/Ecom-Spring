package com.cotiviti.ecom.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Order order;

    private Item item;

    @Column(nullable = false)
    private int quantity;
}
