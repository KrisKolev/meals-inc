package com.example.restaurantapplication.repository;

import com.example.restaurantapplication.model.Employee;
import com.example.restaurantapplication.model.Product;
import com.example.restaurantapplication.model.Table;

import java.util.ArrayList;
import java.util.List;

public class MockDataRestaurant
{
    private List<Product> productList;
    private List<Employee> employeesList;
    private List<Table> tablesList;

    public MockDataRestaurant()
    {
        this.productList = new ArrayList<>(List.of(
                new Product(0, "Full English Breakfast", 15.00),
                new Product(1, "Grilled Chicken", 13.50),
                new Product(2, "Coca Cola", 3.50)
        ));

//        this.employeesList = new ArrayList<>(List.of(
//                new Employee(0, "Kris"),
//                new Employee(1, "Neyko"),
//                new Employee(2, "Petar")
//        ));

        this.tablesList = new ArrayList<>(List.of(
                new Table(0),
                new Table(1),
                new Table(2)
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

    public List<Table> GetTables()
    {
        return this.tablesList;
    }

    public Table GetTableById(int id)
    {
        for (Table table : this.tablesList)
        {
            if (table.getTableId() == id)
            {
                return table;
            }
        }
        return null;
    }
}
