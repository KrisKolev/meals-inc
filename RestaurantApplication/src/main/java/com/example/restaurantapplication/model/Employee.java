package com.example.restaurantapplication.model;

import lombok.Getter;

public class Employee
{
    @Getter private int employeeId;
    @Getter private String employeeName;

    public Employee(int employeeId, String employeeName)
    {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }
}
