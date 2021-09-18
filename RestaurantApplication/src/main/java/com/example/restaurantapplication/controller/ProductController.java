package com.example.restaurantapplication.controller;

import com.example.restaurantapplication.model.Employee;
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

    @GetMapping("/id/{id}")
    public ResponseEntity<Product> GetProductById(@PathVariable("id") int id)
    {
        Product product = mockDataRestaurant.GetProductById(id);

        if (product != null)
        {
            return ResponseEntity.ok().body(product);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<List<Product>> GetProductsByPrice(@PathVariable("price") double price)
    {
        List<Product> products = mockDataRestaurant.GetProductByPrice(price);

        if (products != null)
        {
            return ResponseEntity.ok().body(products);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Product>> GetProductsByName(@PathVariable("name") String name)
    {
        List<Product> products = mockDataRestaurant.GetProductByName(name);

        if (products != null)
        {
            return ResponseEntity.ok().body(products);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
