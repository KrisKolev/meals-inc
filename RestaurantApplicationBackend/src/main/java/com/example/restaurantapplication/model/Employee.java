package com.example.restaurantapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name = "employeeName")
    private String employeeName;

    @Column(name = "employeeRole")
    private String employeeRole;


    //maybe can add inheritance for different types of employees (aka waiter, bartender)

    //in future will be added a list of tables for each employe

    public Employee(String employeeName, String employeeRole)
    {
        this.employeeName = employeeName;
        this.employeeRole = employeeRole;
    }
}
