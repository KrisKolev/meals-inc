package com.example.restaurantapplication.repository;

import com.example.restaurantapplication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>
{
    Employee findByEmployeeUsername(String username);
}
