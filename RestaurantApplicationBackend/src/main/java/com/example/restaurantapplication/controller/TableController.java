package com.example.restaurantapplication.controller;

import com.example.restaurantapplication.dto.TableDTO;
import com.example.restaurantapplication.model.Employee;
import com.example.restaurantapplication.model.Product;
import com.example.restaurantapplication.model.Table;
import com.example.restaurantapplication.repository.MockDataRestaurant;
import com.example.restaurantapplication.serviceInterfaces.IProductService;
import com.example.restaurantapplication.serviceInterfaces.ITableService;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/tables")
public class TableController
{
   @Autowired
   private ITableService service;

   @Autowired
   private IProductService productService;

    @GetMapping()
    public ResponseEntity<List<TableDTO>> GetAllTables()
    {
        List<TableDTO> tables = service.getAllTables();

        if (tables != null)
        {
            return ResponseEntity.ok().body(tables);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> CreateTable(@RequestBody Table table)
    {
        JSONObject jsonObject = new JSONObject();

        try
        {
            Table temp = service.saveAndFlush(table);
            jsonObject.put("message", temp.getTableName() + " saved successfully");
            return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
        }
        catch (JSONException e)
        {
            return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.UNAUTHORIZED);
        }

    }

    @PostMapping("/assignProduct")
    public ResponseEntity<String> AssignProduct(@RequestParam String productId,
                                                @RequestParam String tableId)
    {
        List<Product> productList = new ArrayList<>(List.of(
                productService.getById(Integer.parseInt(productId,10))
        ));

        Table table = service.getById(Integer.parseInt(tableId, 10));

        table.setProducts(productList);
        service.saveAndFlush(table);
        return new ResponseEntity<>("hui",HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Table> DeleteTable(@RequestBody Table table)
    {
        service.deleteTable(table);

        return ResponseEntity.ok().body(table);
    }

//    @GetMapping("/id/{id}")
//    public ResponseEntity<Table> GetTableById(@PathVariable("id")int id)
//    {
//        Table table = mockDataRestaurant.GetTableById(id);
//
//        if (table != null)
//        {
//            return ResponseEntity.ok().body(table);
//        }
//        else
//        {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
