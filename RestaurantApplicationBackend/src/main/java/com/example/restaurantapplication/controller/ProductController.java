package com.example.restaurantapplication.controller;

import com.example.restaurantapplication.dto.ProductDTO;
import com.example.restaurantapplication.model.Product;
import com.example.restaurantapplication.repository.MockDataRestaurant;
import com.example.restaurantapplication.serviceInterfaces.IEmployeeService;
import com.example.restaurantapplication.serviceInterfaces.IProductService;
import com.example.restaurantapplication.serviceInterfaces.ITableService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/products")
public class ProductController
{

    @Autowired
    private IProductService service;

    @GetMapping()
    public ResponseEntity<List<ProductDTO>> GetAllProducts()
    {
        List<ProductDTO> products = service.GetAllProducts();
        if (products != null)
        {
            return ResponseEntity.ok().body(products);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> CreateProduct(@RequestBody Product product)
    {
        JSONObject jsonObject = new JSONObject();

        try
        {
            Product temp = service.saveAndFlush(product);
            jsonObject.put("message", temp.getProductName() + " saved successfully");
            return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
        }
        catch (JSONException e)
        {
            return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping
    public ResponseEntity<Product> DeleteProduct(@RequestBody Product product)
    {
        service.deleteProduct(product);

        return ResponseEntity.ok().body(product);
    }

//    private static final MockDataRestaurant mockDataRestaurant = new MockDataRestaurant();

//    @GetMapping("/id/{id}")
//    public ResponseEntity<Product> GetProductById(@PathVariable("id") int id)
//    {
//        Product product = mockDataRestaurant.GetProductById(id);
//
//        if (product != null)
//        {
//            return ResponseEntity.ok().body(product);
//        }
//        else
//        {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("/price/{price}")
//    public ResponseEntity<List<Product>> GetProductsByPrice(@PathVariable("price") double price)
//    {
//        List<Product> products = mockDataRestaurant.GetProductByPrice(price);
//
//        if (products != null)
//        {
//            return ResponseEntity.ok().body(products);
//        }
//        else
//        {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("/name/{name}")
//    public ResponseEntity<List<Product>> GetProductsByName(@PathVariable("name") String name)
//    {
//        List<Product> products = mockDataRestaurant.GetProductByName(name);
//
//        if (products != null)
//        {
//            return ResponseEntity.ok().body(products);
//        }
//        else
//        {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
