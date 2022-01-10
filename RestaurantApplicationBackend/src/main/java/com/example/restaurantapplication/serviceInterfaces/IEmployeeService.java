package com.example.restaurantapplication.serviceInterfaces;

import com.example.restaurantapplication.dto.EmployeeDTO;
import com.example.restaurantapplication.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService
{
    List<EmployeeDTO> GetAllEmployees();
    void AddEmployee(Employee employee);
    void deleteEmployee(int id);
    Employee saveAndFlush(Employee employee);
    Employee findByUsername(String username);
}
