package com.example.restaurantapplication.serviceInterfaces;

import com.example.restaurantapplication.dto.ProductDTO;
import com.example.restaurantapplication.dto.TableDTO;
import com.example.restaurantapplication.model.DinnerTable;

import java.util.List;

public interface ITableService
{
    List<TableDTO> getAllTables();
    void addTable(DinnerTable table);
    void deleteTable(DinnerTable table);
    DinnerTable saveAndFlush(DinnerTable table);
    DinnerTable getById(Integer id);
    TableDTO getByIdDTO(Integer id);
    List<ProductDTO> getProductsByTable(Integer tableId);
    void deleteProductsByTable(Integer tableId);
}
