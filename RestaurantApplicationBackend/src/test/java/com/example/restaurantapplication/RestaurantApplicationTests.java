package com.example.restaurantapplication;

import com.example.restaurantapplication.model.Employee;
import com.example.restaurantapplication.repository.MockDataRestaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

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
