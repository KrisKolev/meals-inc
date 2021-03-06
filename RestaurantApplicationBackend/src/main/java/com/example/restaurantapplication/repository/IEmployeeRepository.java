package com.example.restaurantapplication.repository;

import com.example.restaurantapplication.dto.EmployeeDTO;
import com.example.restaurantapplication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>
{
    Employee findByEmployeeUsername(String username);
}
