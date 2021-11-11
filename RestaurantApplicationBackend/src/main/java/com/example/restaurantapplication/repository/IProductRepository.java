package com.example.restaurantapplication.repository;

import com.example.restaurantapplication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long>
{

}
