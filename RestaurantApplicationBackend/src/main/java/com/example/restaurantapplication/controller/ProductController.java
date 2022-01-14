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

    @GetMapping("/getById")
    public ProductDTO GetProductById(@RequestParam("productID")int productID)
    {
        ProductDTO product = service.getByIdDTO(productID);
        return product;
    }

    @PostMapping
    public Product CreateProduct(@RequestParam("productName") String productName,
                                 @RequestParam("productPrice") double productPrice)
    {
        Product product = service.saveAndFlush(new Product(productName, productPrice));
        return product;
    }

    @DeleteMapping
    public void DeleteProduct(@RequestParam int productID)
    {
        service.deleteProduct(productID);
    }

}
