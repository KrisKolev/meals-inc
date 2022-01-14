package com.example.restaurantapplication.service;

import com.example.restaurantapplication.dalInterfaces.ITableDal;
import com.example.restaurantapplication.dto.ProductDTO;
import com.example.restaurantapplication.dto.TableDTO;
import com.example.restaurantapplication.model.DinnerTable;
import com.example.restaurantapplication.model.Product;
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
    public List<ProductDTO> getProductsByTable(Integer tableId)
    {
        return getById(tableId).getProducts()
                .stream()
                .map(this::ConvertProdDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProductsByTable(Integer tableId)
    {
        
    }

    @Override
    public void addTable(DinnerTable table)
    {
        dal.addTable(table);
    }

    @Override
    public void deleteTable(DinnerTable table)
    {
        dal.deleteTable(table);
    }

    @Override
    public DinnerTable saveAndFlush(DinnerTable table)
    {
        return dal.saveAndFlush(table);
    }

    @Override
    public DinnerTable getById(Integer id)
    {
        return dal.getById(id);
    }

    @Override
    public TableDTO getByIdDTO(Integer id)
    {
        return ConvertDTO(dal.getById(id));
    }

    private ProductDTO ConvertProdDTO(Product product)
    {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }

    private TableDTO ConvertDTO(DinnerTable table)
    {
        TableDTO tableDTO = modelMapper.map(table, TableDTO.class);
        return tableDTO;
    }
}
