package com.example.restaurantapplication.service;

import com.example.restaurantapplication.dalInterfaces.ITableDal;
import com.example.restaurantapplication.dto.TableDTO;
import com.example.restaurantapplication.model.Table;
import com.example.restaurantapplication.serviceInterfaces.ITableService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableService implements ITableService
{
    @Autowired
    ModelMapper modelMapper;

    ITableDal dal;

    @Autowired
    public TableService(ITableDal dal)
    {
        this.dal = dal;
    }

    @Override
    public List<TableDTO> getAllTables()
    {
        return dal.getAllTables()
                .stream()
                .map(this::ConvertDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void addTable(Table table)
    {
        dal.addTable(table);
    }

    @Override
    public void deleteTable(Table table)
    {
        dal.deleteTable(table);
    }

    @Override
    public Table saveAndFlush(Table table)
    {
        return dal.saveAndFlush(table);
    }

    @Override
    public Table getById(Integer id)
    {
        return dal.getById(id);
    }

    private TableDTO ConvertDTO(Table table)
    {
        TableDTO tableDTO = modelMapper.map(table, TableDTO.class);
        return tableDTO;
    }
}
