package com.example.restaurantapplication.repository;

import com.example.restaurantapplication.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MockDataRestaurant
{
    private List<Product> productList;

    public MockDataRestaurant()
    {
        this.productList = new ArrayList<>(List.of(
                new Product(0, "Full English Breakfast", 15),
                new Product(1, "Grilled Chicken", 13)
        ));
    }

    public List<Product> GetProducts()
    {
        return this.productList;
    }

    public Product GetProduct(int id)
    {
        for (Product product : this.productList)
        {
            if (product.getProductID() == id)
            {
                return product;
            }
        }
        return null;
    }
}
