package com.example.restaurantapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "employee")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name = "employeeName", nullable = false)
    private String employeeName;

    @Column(name = "employeeRole", nullable = false)
    private String employeeRole;

    @Column(name = "employeeUsername",nullable = false, unique = true)
    private String employeeUsername;

    @Column
    private String employeePassword;

    //in future will be added a list of tables for each employe

    public Employee(String employeeName, String employeeRole, String employeeUsername, String employeePassword)
    {
        this.employeeName = employeeName;
        this.employeeRole = employeeRole;
        this.employeeUsername = employeeUsername;
        this.employeePassword = employeePassword;
    }

    public int getEmployeeId()
    {
        return employeeId;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    public String getEmployeeRole()
    {
        return employeeRole;
    }

    public String getEmployeeUsername()
    {
        return employeeUsername;
    }

    public void setPassword(String employeePassword)
    {
        this.employeePassword = employeePassword;
    }

    public String getEmployeePassword()
    {
        return employeePassword;
    }
}
