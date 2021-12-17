package com.example.restaurantapplication.dalInterfaces;

import com.example.restaurantapplication.model.Table;

import java.util.List;

public interface ITableDal
{
    List<Table> getAllTables();
    void addTable(Table table);
    void deleteTable(Table table);
    Table saveAndFlush(Table table);
    Table getById(Integer id);
}
