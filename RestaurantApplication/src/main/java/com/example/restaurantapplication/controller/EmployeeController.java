package com.example.restaurantapplication.controller;

import com.example.restaurantapplication.model.Employee;
import com.example.restaurantapplication.repository.MockDataRestaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController
{
    private static final MockDataRestaurant mockDataRestaurant = new MockDataRestaurant();

    @GetMapping()
    public ResponseEntity<List<Employee>> GetAllEmployees()
    {
        List<Employee> employees = mockDataRestaurant.GetEmployees();

        if (employees != null)
        {
            return ResponseEntity.ok().body(employees);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> GetEmployeeById(@PathVariable("id") int id)
    {
        Employee employee = mockDataRestaurant.GetEmployee(id);

        if (employee != null)
        {
            return ResponseEntity.ok().body(employee);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
