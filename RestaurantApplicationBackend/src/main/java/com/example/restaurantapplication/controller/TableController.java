package com.example.restaurantapplication.controller;

import com.example.restaurantapplication.dto.ProductDTO;
import com.example.restaurantapplication.dto.TableDTO;
import com.example.restaurantapplication.model.Employee;
import com.example.restaurantapplication.model.Product;
import com.example.restaurantapplication.model.DinnerTable;
import com.example.restaurantapplication.serviceInterfaces.IProductService;
import com.example.restaurantapplication.serviceInterfaces.ITableService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/tables")
public class TableController
{
   @Autowired
   private ITableService service;

   @Autowired
   private IProductService productService;

   private DinnerTable dinnerTable;

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

    @GetMapping("/getById")
    public TableDTO GetTableById(@RequestParam("tableId")int tableId)
    {
        TableDTO table = service.getByIdDTO(tableId);
        return table;
    }

    @PostMapping
    public ResponseEntity<String> CreateTable(@RequestBody DinnerTable table)
    {
        JSONObject jsonObject = new JSONObject();
        try
        {
            DinnerTable temp = service.saveAndFlush(table);
            jsonObject.put("message", temp.getTableName() + " saved successfully");
            return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
        }
        catch (JSONException e)
        {
            return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.UNAUTHORIZED);
        }

    }

    @PostMapping("/assignProduct")
    public ResponseEntity<String> AssignProduct(@RequestParam String productID,
                                                @RequestParam String tableId)
    {
        DinnerTable table = service.getById(Integer.parseInt(tableId, 10));
        Product product = productService.getById(Integer.parseInt(productID, 10));
        table.getProducts().add(product);
        product.getPlace().add(table);
        service.addTable(table);
        return new ResponseEntity<>("blah",HttpStatus.OK);
    }

    @GetMapping("/getAssigned")
    public ResponseEntity<?> GetAssigned(@RequestParam int tableId)
    {
        List<ProductDTO> products = service.getProductsByTable(tableId);
        return ResponseEntity.ok().body(products);
    }

    @DeleteMapping("/deleteAssigned")
    public ResponseEntity<?> DeleteAssigned(@RequestParam int tableId)
    {
        DinnerTable table = service.getById(tableId);
        List<Product> products = table.getProducts();

        for (Product prod : products)
        {
            table.getProducts().remove(prod);
            prod.getPlace().remove(table);
            service.saveAndFlush(table);
        }

        return ResponseEntity.ok().body("Products deleted");
    }

    @DeleteMapping
    public void DeleteTable(@RequestParam int tableId)
    {
        service.deleteTable(tableId);
    }
}
