package com.example.restaurantapplication.dalInterfaces;

import com.example.restaurantapplication.model.Employee;

import java.util.List;

public interface IEmployeeDal
{
    List<Employee> GetAllEmployees();
    void AddEmployee(Employee employee);
    void deleteEmployee(int id);
    Employee saveAndFlush(Employee employee);
}
