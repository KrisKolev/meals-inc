package com.example.restaurantapplication.repository;

import com.example.restaurantapplication.dto.ProductDTO;
import com.example.restaurantapplication.model.DinnerTable;
import com.example.restaurantapplication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer>
{

}
