package com.example.restaurantapplication.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Table
{
    @Getter private int tableId;

    private List<Product> products;

    // in future will be added a list of Product objects for each table

    public Table(int tableId)
    {
        products = new ArrayList<>();
        this.tableId = tableId;
    }
}
