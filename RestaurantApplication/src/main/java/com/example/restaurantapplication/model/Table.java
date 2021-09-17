package com.example.restaurantapplication.model;

import lombok.Getter;

public class Table
{
    @Getter private int tableId;

    // in future will be added a list of Product objects for each table

    public Table(int tableId)
    {
        this.tableId = tableId;
    }
}
