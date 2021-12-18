package com.example.restaurantapplication.serviceInterfaces;

import com.example.restaurantapplication.dto.ProductDTO;
import com.example.restaurantapplication.model.Product;

import java.util.List;

public interface IProductService
{
    List<ProductDTO> GetAllProducts();
    void AddProduct(Product product);
    Product saveAndFlush(Product product);
    Product getById(Integer id);
    void deleteProduct(Product product);
}
