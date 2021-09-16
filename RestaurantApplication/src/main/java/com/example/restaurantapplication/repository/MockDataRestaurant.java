package com.example.restaurantapplication.repository;

import com.example.restaurantapplication.model.Employee;
import com.example.restaurantapplication.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MockDataRestaurant
{
    private List<Product> productList;
    private List<Employee> employeesList;

    public MockDataRestaurant()
    {
        this.productList = new ArrayList<>(List.of(
                new Product(0, "Full English Breakfast", 15),
                new Product(1, "Grilled Chicken", 13)
        ));

        this.employeesList = new ArrayList<>(List.of(
                new Employee(0, "Kris"),
                new Employee(1, "Neyko"),
                new Employee(2, "Petar")
        ));
    }

    public List<Product> GetProducts()
    {
        return this.productList;
    }

    public Product GetProduct(int id)
    {
        for (Product product : this.productList)
        {
            if (product.getProductID() == id)
            {
                return product;
            }
        }
        return null;
    }

    public List<Employee> GetEmployees()
    {
        return this.employeesList;
    }

    public Employee GetEmployee(int id)
    {
        for (Employee employee : this.employeesList)
        {
            if (employee.getEmployeeId() == id)
            {
                return employee;
            }
        }
        return null;
    }
}
