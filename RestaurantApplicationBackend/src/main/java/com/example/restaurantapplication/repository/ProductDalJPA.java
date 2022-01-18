package com.example.restaurantapplication.repository;

import com.example.restaurantapplication.dalInterfaces.IProductDal;
import com.example.restaurantapplication.model.DinnerTable;
import com.example.restaurantapplication.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDalJPA implements IProductDal
{
    IProductRepository repo;

    @Autowired
    public ProductDalJPA(IProductRepository repo)
    {
        this.repo = repo;
//        repo.save(new Product("Full English Breakfast", 15.00));
//        repo.save(new Product("Grilled Chicken", 13.50));
//        repo.save(new Product("Coca-Cola", 3.50));
    }


    @Override
    public List<Product> GetAllProducts()
    {
        return repo.findAll();
    }

    @Override
    public void AddProduct(Product product)
    {
        repo.save(product);
    }

    @Override
    public Product saveAndFlush(Product product)
    {
        return repo.saveAndFlush(product);
    }

    @Override
    public void deleteProduct(int id)
    {
        repo.deleteById(id);
    }

    @Override
    public Product getById(Integer id)
    {
        return repo.getById(id);
    }
}
