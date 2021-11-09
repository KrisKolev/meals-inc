package com.example.restaurantapplication.model;

import lombok.Getter;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private int employeeId;

    @Column(name = "employeeName")
    @Getter private String employeeName;


    //maybe can add inheritance for different types of employees (aka waiter, bartender)

    //in future will be added a list of tables for each employee

    public Employee() { }

    public Employee(String employeeName)
    {
        this.employeeName = employeeName;
    }
}
