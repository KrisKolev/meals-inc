package com.example.restaurantapplication.service;

import com.example.restaurantapplication.dalInterfaces.IEmployeeDal;
import com.example.restaurantapplication.dto.EmployeeDTO;
import com.example.restaurantapplication.model.Employee;
import com.example.restaurantapplication.serviceInterfaces.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService
{
    IEmployeeDal dal;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public EmployeeService(IEmployeeDal dal)
    {
        this.dal = dal;
    }

    @Override
    public List<EmployeeDTO> GetAllEmployees()
    {
        return dal.GetAllEmployees()
                .stream().map(this::ConvertDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void AddEmployee(Employee employee)
    {
        dal.AddEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee)
    {
        dal.deleteEmployee(employee);
    }

    @Override
    public Employee saveAndFlush(Employee employee)
    {
        return dal.saveAndFlush(employee);
    }

    private EmployeeDTO ConvertDTO(Employee employee)
    {
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        return employeeDTO;
    }
}
