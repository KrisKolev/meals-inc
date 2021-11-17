package com.example.restaurantapplication.dalInterfaces;

import com.example.restaurantapplication.model.Product;

import java.util.List;

public interface IProductDal
{
    List<Product> GetAllProducts();
    void AddProduct(Product product);
}