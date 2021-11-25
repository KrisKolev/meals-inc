package com.example.restaurantapplication.service;

import com.example.restaurantapplication.dalInterfaces.IEmployeeDal;
import com.example.restaurantapplication.model.Employee;
import com.example.restaurantapplication.serviceInterfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService
{
    IEmployeeDal dal;

    @Autowired
    public EmployeeService(IEmployeeDal dal)
    {
        this.dal = dal;
    }

    @Override
    public List<Employee> GetAllEmployees()
    {
        return dal.GetAllEmployees();
    }

    @Override
    public void AddEmployee(Employee employee)
    {
        dal.AddEmployee(employee);
    }

    @Override
    public Employee saveAndFlush(Employee employee)
    {
        return dal.saveAndFlush(employee);
    }
}
