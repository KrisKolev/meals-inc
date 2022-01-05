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
//        repo.save(new Employee("Kris", "Manager", "kris1", "admin"));
//        repo.save(new Employee("Neyko", "Waiter", "neyko1", "1234"));
//        repo.save(new Employee("Petar", "Bartender", "petar1", "1234"));
//        repo.save(new Employee("Zori", "Waitress", "zori1", "1234"));
//        repo.save(new Employee("Misha", "Bartender", "misha1", "1234"));
//        repo.save(new Employee("Presli", "Waitress", "presli1", "1234"));
//        repo.save(new Employee("Dobri", "General", "dobri1", "admin"));
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

    @Override
    public void deleteEmployee(int id)
    {
        repo.deleteById(id);
    }

    @Override
    public Employee saveAndFlush(Employee employee)
    {
        return repo.saveAndFlush(employee);
    }

}
