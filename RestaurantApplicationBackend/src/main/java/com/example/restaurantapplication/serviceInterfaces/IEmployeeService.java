package com.example.restaurantapplication.serviceInterfaces;

import com.example.restaurantapplication.model.Employee;

import java.util.List;

public interface IEmployeeService
{
    List<Employee> GetAllEmployees();
    void AddEmployee(Employee employee);
}
