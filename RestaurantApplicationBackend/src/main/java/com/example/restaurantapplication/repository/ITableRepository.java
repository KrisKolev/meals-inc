package com.example.restaurantapplication.repository;

import com.example.restaurantapplication.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITableRepository extends JpaRepository<Table, Integer>
{

}
