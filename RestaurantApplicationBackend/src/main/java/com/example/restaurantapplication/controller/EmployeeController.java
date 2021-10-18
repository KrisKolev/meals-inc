package com.example.restaurantapplication.controller;

import com.example.restaurantapplication.model.Employee;
import com.example.restaurantapplication.repository.MockDataRestaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
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

    @GetMapping("/id/{id}")
    public ResponseEntity<Employee> GetEmployeeById(@PathVariable("id") int id)
    {
        Employee employee = mockDataRestaurant.GetEmployeeById(id);

        if (employee != null)
        {
            return ResponseEntity.ok().body(employee);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Employee>> GetEmployeeByName(@PathVariable("name") String name)
    {
        List<Employee> employees = mockDataRestaurant.GetEmployeeByName(name);

        if (employees != null)
        {
            return ResponseEntity.ok().body(employees);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
