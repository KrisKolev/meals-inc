package com.example.restaurantapplication.service;

import com.example.restaurantapplication.dalInterfaces.IEmployeeDal;
import com.example.restaurantapplication.dto.EmployeeDTO;
import com.example.restaurantapplication.model.Employee;
import com.example.restaurantapplication.repository.EmployeeDalJPA;
import com.example.restaurantapplication.serviceInterfaces.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.websocket.Encoder;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService implements IEmployeeService
{
    IEmployeeDal dal;
//    private final PasswordEncoder passwordEncoder;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public EmployeeService(IEmployeeDal dal/* PasswordEncoder passwordEncoder*/)
    {
//        this.passwordEncoder = passwordEncoder;
        this.dal = dal;
        //this.saveAndFlush(new Employee("test", "someone", "test1", "test"));
    }

    @Override
    public List<EmployeeDTO> GetAllEmployees()
    {
        return dal.GetAllEmployees()
                .stream()
                .map(this::ConvertDTO)
                .collect(Collectors.toList());
    }

@Override
    public void AddEmployee(Employee employee)
    {
        dal.AddEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id)
    {
        dal.deleteEmployee(id);
    }

    @Override
    public Employee saveAndFlush(Employee employee)
    {
//        employee.setPassword(passwordEncoder.encode(employee.getEmployeePassword()));
        return dal.saveAndFlush(employee);
    }

    private EmployeeDTO ConvertDTO(Employee employee)
    {
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
        return employeeDTO;
    }

}









