package com.example.restaurantapplication.repository;

import com.example.restaurantapplication.model.Employee;
import com.example.restaurantapplication.model.Product;
import com.example.restaurantapplication.model.DinnerTable;

import java.util.ArrayList;
import java.util.List;

public class MockDataRestaurant
{
    private List<Product> productList;
    private List<Employee> employeesList;
    private List<DinnerTable> tablesList;

    public MockDataRestaurant()
    {
        this.productList = new ArrayList<>(List.of(
                new Product("Full English Breakfast", 15.00),
                new Product("Grilled Chicken", 13.50),
                new Product("Coca Cola", 3.50)
        ));

        this.employeesList = new ArrayList<>(List.of(
                new Employee("Kris", "Manager", "kris1", "admin"),
                new Employee("Neyko", "Waiter", "neyko1", "1234"),
                new Employee("Petar", "Bartender", "pesho", "3bigballs")
        ));

        this.tablesList = new ArrayList<>(List.of(
                new DinnerTable("1"),
                new DinnerTable("2"),
                new DinnerTable("3")
        ));
    }

/////////////////////////////////////////////////////////////////////////////////////

    public List<Product> GetProducts()
    {
        return this.productList;
    }

    public Product GetProductById(int id)
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

    public List<Product> GetProductByPrice(double price)
    {
        List<Product> productsTemp = new ArrayList<>();

        for (Product product : this.productList)
        {
            if (product.getProductPrice() == price)
            {
                productsTemp.add(product);
            }
        }
        return productsTemp;
    }

    public List<Product> GetProductByName(String name)
    {
        List<Product> productsTemp = new ArrayList<>();

        for (Product product : this.productList)
        {
            if (product.getProductName().contains(name))
            {
                productsTemp.add(product);
            }
        }
        return productsTemp;
    }

/////////////////////////////////////////////////////////////////////////////////////

    public List<Employee> GetEmployees()
    {
        return this.employeesList;
    }

    public Employee GetEmployeeById(int id)
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

    public List<Employee> GetEmployeeByName(String name)
    {
        List<Employee> employeesTemp = new ArrayList<>();

        for (Employee employee : this.employeesList)
        {
            if (employee.getEmployeeName().contains(name))
            {
                employeesTemp.add(employee);
            }
        }
        return employeesTemp;
    }

/////////////////////////////////////////////////////////////////////////////////////

    public List<DinnerTable> GetTables()
    {
        return this.tablesList;
    }

    public DinnerTable GetTableById(int id)
    {
        for (DinnerTable table : this.tablesList)
        {
            if (table.getTableId() == id)
            {
                return table;
            }
        }
        return null;
    }
}
