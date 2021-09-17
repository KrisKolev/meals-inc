package com.example.restaurantapplication.model;

import lombok.Getter;

public class Employee
{
    //maybe can add inheritance for different types of employees (aka waiter, bartender)

    @Getter private int employeeId;
    @Getter private String employeeName;

    //in future will be added a list of tables for each employee

    public Employee(int employeeId, String employeeName)
    {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }
}
