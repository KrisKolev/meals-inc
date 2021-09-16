package com.example.restaurantapplication.controller;

import com.example.restaurantapplication.model.Product;
import com.example.restaurantapplication.repository.MockDataRestaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController
{
    private static final MockDataRestaurant mockDataRestaurant = new MockDataRestaurant();

    @GetMapping()
    public ResponseEntity<List<Product>> GetAllProducts()
    {
        List<Product> products = mockDataRestaurant.GetProducts();
        if (products != null)
        {
            return ResponseEntity.ok().body(products);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> GetProductById(@PathVariable("id") int id)
    {
        Product product = mockDataRestaurant.GetProduct(id);

        if (product != null)
        {
            return ResponseEntity.ok().body(product);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}