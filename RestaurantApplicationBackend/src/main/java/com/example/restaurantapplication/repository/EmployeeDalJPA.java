package com.example.restaurantapplication.repository;

import com.example.restaurantapplication.dalInterfaces.IEmployeeDal;
import com.example.restaurantapplication.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDalJPA implements IEmployeeDal
{
    IEmployeeRepository repo;

    @Autowired
    public EmployeeDalJPA(IEmployeeRepository repo)
    {
        this.repo = repo;
//        repo.save(new Employee("Kris", "Manager"));
//        repo.save(new Employee("Neyko", "Waiter"));
//        repo.save(new Employee("Petar", "Bartender"));
//        repo.save(new Employee("Zori", "Waitress"));
//        repo.save(new Employee("Misha", "Bartender"));
//        repo.save(new Employee("Presli", "Waitress"));
    }

    @Override
    public List<Employee> GetAllEmployees()
    {
        return repo.findAll();
    }

    @Override
    public void AddEmployee(Employee employee)
    {
        repo.save(employee);
    }
}
