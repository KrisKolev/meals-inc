package com.example.restaurantapplication.repository;

import com.example.restaurantapplication.model.DinnerTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITableRepository extends JpaRepository<DinnerTable, Integer>
{

}
