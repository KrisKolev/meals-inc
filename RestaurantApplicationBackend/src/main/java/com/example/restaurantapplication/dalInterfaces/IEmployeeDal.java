package com.example.restaurantapplication.dalInterfaces;

import com.example.restaurantapplication.model.Employee;

import java.util.List;

public interface IEmployeeDal
{
    List<Employee> GetAllEmployees();
    void AddEmployee(Employee employee);
    Employee saveAndFlush(Employee employee);
}
