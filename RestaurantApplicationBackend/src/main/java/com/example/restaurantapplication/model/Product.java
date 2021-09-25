package com.example.restaurantapplication.model;

import lombok.Getter;

public class Product
{
    @Getter private int productID;
    @Getter private String productName;
    @Getter private double productPrice;

    public Product(int productID, String productName, double productPrice)
    {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }
}

