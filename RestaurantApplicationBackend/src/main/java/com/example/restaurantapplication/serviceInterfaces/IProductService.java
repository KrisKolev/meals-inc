package com.example.restaurantapplication.serviceInterfaces;

import com.example.restaurantapplication.model.Product;

import java.util.List;

public interface IProductService
{
    List<Product> GetAllProducts();
    void AddProduct(Product product);
}
