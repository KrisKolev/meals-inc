package com.example.restaurantapplication.serviceInterfaces;

import com.example.restaurantapplication.dto.TableDTO;
import com.example.restaurantapplication.model.Table;

import java.util.List;

public interface ITableService
{
    List<TableDTO> getAllTables();
    void addTable(Table table);
    void deleteTable(Table table);
    Table saveAndFlush(Table table);
    Table getById(Integer id);
}
