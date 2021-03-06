package com.example.restaurantapplication.dalInterfaces;

import com.example.restaurantapplication.model.DinnerTable;

import java.util.List;

public interface ITableDal
{
    List<DinnerTable> getAllTables();
    void addTable(DinnerTable table);
    void deleteTable(int id);
    DinnerTable saveAndFlush(DinnerTable table);
    DinnerTable getById(Integer id);
}
