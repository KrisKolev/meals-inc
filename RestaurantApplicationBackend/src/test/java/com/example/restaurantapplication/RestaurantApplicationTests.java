package com.example.restaurantapplication;

import com.example.restaurantapplication.controller.EmployeeController;
import com.example.restaurantapplication.dalInterfaces.IEmployeeDal;
import com.example.restaurantapplication.dto.EmployeeDTO;
import com.example.restaurantapplication.model.Employee;
import com.example.restaurantapplication.repository.EmployeeDalJPA;
import com.example.restaurantapplication.repository.IEmployeeRepository;
import com.example.restaurantapplication.repository.MockDataRestaurant;
import com.example.restaurantapplication.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RestaurantApplicationTests
{
    private EmployeeController _eContr = new EmployeeController();

    @Test
    public void GetEmployeeTest()
    {
        MockDataRestaurant mockDataRestaurant = new MockDataRestaurant();

        mockDataRestaurant.GetEmployees();

        Assertions.assertEquals(mockDataRestaurant.GetEmployees().size(), 3 );
    }

    @Test
    public void createEmployeeTest()
    {
        Employee empl = getValidEmployee();

        ResponseEntity response = _eContr.CreateEmployee(empl);

        assert(!response.getStatusCode().isError());

    }

    private Employee getValidEmployee()
    {
        Employee employee = new Employee();
        employee.setEmployeeName("Name");
        employee.setEmployeeRole("Role");
        employee.setEmployeeUsername("username1");
        employee.setEmployeePassword("password");

        return employee;
    }

    @Test
    public void GetProductsTest()
    {
        MockDataRestaurant mockDataRestaurant = new MockDataRestaurant();

        mockDataRestaurant.GetProducts();

        Assertions.assertEquals(mockDataRestaurant.GetProducts().size(), 3);
    }

    @Test
    public void GetTablesTest()
    {
        MockDataRestaurant mockDataRestaurant = new MockDataRestaurant();

        mockDataRestaurant.GetProducts();

        Assertions.assertEquals(mockDataRestaurant.GetTables().size(), 3);
    }
}
