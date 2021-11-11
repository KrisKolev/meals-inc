package com.example.restaurantapplication.model;

import lombok.Getter;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private int productID;

    @Column(name = "productName")
    @Getter private String productName;

    @Column(name = "productPrice")
    @Getter private double productPrice;

    public Product() { }

    public Product(String productName, double productPrice)
    {
        this.productName = productName;
        this.productPrice = productPrice;
    }
}

