package com.example.restaurantapplication.dalInterfaces;

import com.example.restaurantapplication.model.Product;

import java.util.List;

public interface IProductDal
{
    List<Product> GetAllProducts();
    void AddProduct(Product product);
    Product saveAndFlush(Product product);
    Product getById(Integer id);
    void deleteProduct(int id);
}