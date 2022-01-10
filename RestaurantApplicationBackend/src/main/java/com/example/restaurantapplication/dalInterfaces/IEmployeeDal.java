package com.example.restaurantapplication.dalInterfaces;

import com.example.restaurantapplication.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeDal
{
    List<Employee> GetAllEmployees();
    void AddEmployee(Employee employee);
    void deleteEmployee(int id);
    Employee findByUsername(String username);
    Employee saveAndFlush(Employee employee);
}
