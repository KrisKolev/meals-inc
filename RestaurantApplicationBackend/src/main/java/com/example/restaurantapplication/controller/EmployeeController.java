package com.example.restaurantapplication.controller;

import com.example.restaurantapplication.dto.EmployeeDTO;
import com.example.restaurantapplication.model.Employee;
import com.example.restaurantapplication.repository.MockDataRestaurant;
import com.example.restaurantapplication.serviceInterfaces.IEmployeeService;
import org.codehaus.jackson.map.util.JSONPObject;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/employees")
public class EmployeeController
{

    @Autowired
    private IEmployeeService service;

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> GetAllEmployees()
    {
        List<EmployeeDTO> employees = service.GetAllEmployees();

        if (employees != null)
        {
            return ResponseEntity.ok().body(employees);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> CreateEmployee(@RequestBody Employee employee)
    {
//        service.AddEmployee(employee);
//
//        return ResponseEntity.ok().body(employee);

        JSONObject jsonObject = new JSONObject();

        try
        {
            Employee temp = service.saveAndFlush(employee);
            jsonObject.put("message", temp.getEmployeeName() + " saved successfully");
            return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
        }
        catch (JSONException e)
        {
            return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping
    public ResponseEntity<Employee> DeleteEmployee(@RequestBody Employee employee)
    {
        service.deleteEmployee(employee);

        return ResponseEntity.ok().body(employee);
    }

//    @GetMapping("/id/{id}")
//    public ResponseEntity<Employee> GetEmployeeById(@PathVariable("id") int id)
//    {
//        Employee employee = mockDataRestaurant.GetEmployeeById(id);
//
//        if (employee != null)
//        {
//            return ResponseEntity.ok().body(employee);
//        }
//        else
//        {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("/name/{name}")
//    public ResponseEntity<List<Employee>> GetEmployeeByName(@PathVariable("name") String name)
//    {
//        List<Employee> employees = mockDataRestaurant.GetEmployeeByName(name);
//
//        if (employees != null)
//        {
//            return ResponseEntity.ok().body(employees);
//        }
//        else
//        {
//            return ResponseEntity.notFound().build();
//        }
//    }
}
