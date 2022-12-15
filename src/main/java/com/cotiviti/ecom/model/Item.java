package com.cotiviti.ecom.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)
    private int category_id;

    @Column(length = 50, nullable = false, unique = true)
    private String title;

    @Column(length = 500, nullable = false)
    private String description;

    @Column(scale = 10, nullable = false, precision = 2, columnDefinition = "DOUBLE(10,2)")
    private double price;

}
