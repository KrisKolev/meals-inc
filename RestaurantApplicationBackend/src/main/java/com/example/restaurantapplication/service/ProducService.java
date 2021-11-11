package com.example.restaurantapplication.service;

import com.example.restaurantapplication.dalInterfaces.IProductDal;
import com.example.restaurantapplication.model.Product;
import com.example.restaurantapplication.serviceInterfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducService implements IProductService
{
    IProductDal dal;

    @Autowired
    public ProducService(IProductDal dal)
    {
        this.dal = dal;
    }

    @Override
    public List<Product> GetAllProducts()
    {
        return dal.GetAllProducts();
    }

    @Override
    public void AddProduct(Product product)
    {
        dal.AddProduct(product);
    }
}
