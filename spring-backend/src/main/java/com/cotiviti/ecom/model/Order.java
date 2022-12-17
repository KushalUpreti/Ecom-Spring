package com.cotiviti.ecom.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private User user;

    @Column(name = "order_date",nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false,precision = 2)
    private double price;

}
