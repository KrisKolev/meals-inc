package com.example.restaurantapplication;

import com.example.restaurantapplication.repository.MockDataRestaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestaurantApplicationTests
{
    @Test
    public void GetEmployeeTest()
    {
        MockDataRestaurant mockDataRestaurant = new MockDataRestaurant();

        mockDataRestaurant.GetEmployees();

        Assertions.assertEquals(mockDataRestaurant.GetEmployees().size(), 3 );
    }

//    @Test
//    public void createEmployeeTest()
//    {
//        Employee empl = getValidEmployee();
//
//        ResponseEntity response = _eContr.CreateEmployee(empl);
//
//        assert(response.getStatusCode().is2xxSuccessful());
//    }
//
//    private Employee getValidEmployee()
//    {
//        Employee employee = new Employee();
//        employee.setEmployeeName("Name");
//        employee.setEmployeeRole("Role");
//        employee.setEmployeeUsername("username1");
//        employee.setEmployeePassword("password");
//
//        return employee;
//    }

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
