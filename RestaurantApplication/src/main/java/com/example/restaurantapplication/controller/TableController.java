package com.example.restaurantapplication.controller;

import com.example.restaurantapplication.model.Table;
import com.example.restaurantapplication.repository.MockDataRestaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tables")
public class TableController
{
    private static final MockDataRestaurant mockDataRestaurant = new MockDataRestaurant();

    @GetMapping()
    public ResponseEntity<List<Table>> GetAllTables()
    {
        List<Table> tables = mockDataRestaurant.GetTables();

        if (tables != null)
        {
            return ResponseEntity.ok().body(tables);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Table> GetTableById(@PathVariable("id")int id)
    {
        Table table = mockDataRestaurant.GetTableById(id);

        if (table != null)
        {
            return ResponseEntity.ok().body(table);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
