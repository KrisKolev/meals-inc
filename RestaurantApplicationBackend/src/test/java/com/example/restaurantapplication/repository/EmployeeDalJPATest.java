package com.example.restaurantapplication.repository;

import com.example.restaurantapplication.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class EmployeeDalJPATest
{
    @Mock
    private IEmployeeRepository repo;
    private AutoCloseable autoCloseable;
    private EmployeeDalJPA employeeDalJPA;

    @BeforeEach
    void setUp()
    {
        autoCloseable = MockitoAnnotations.openMocks(this);
        employeeDalJPA = new EmployeeDalJPA(repo);
    }

    @AfterEach
    void tearDown() throws Exception
    {
        autoCloseable.close();
    }

    @Test
    void createEmployeeTest()
    {
        Employee empl = getValidEmployee();

        repo.saveAndFlush(empl);

        ArgumentCaptor<Employee> argumentCaptor = ArgumentCaptor.forClass(Employee.class);
        verify(repo).saveAndFlush(argumentCaptor.capture());

        Employee capturedEmpl = argumentCaptor.getValue();
        assertThat(capturedEmpl).isEqualTo(empl);
    }

    @Test
    void getAllEmployeesTest()
    {
        employeeDalJPA.GetAllEmployees();

        verify(repo).findAll();
    }

    @Test
    void findEmployeeByUsernameTest()
    {
        Employee empl = getValidEmployee();

        employeeDalJPA.AddEmployee(empl);
        repo.saveAndFlush(empl);

        Employee e = employeeDalJPA.findByUsername("username1");
        verify(repo).findByEmployeeUsername("username1");
    }

    @Test
    void deleteEmployeeTest()
    {
        Employee empl = getValidEmployee();

        ArgumentCaptor<Employee> argumentCaptor = ArgumentCaptor.forClass(Employee.class);
        repo.saveAndFlush(empl);
        verify(repo).saveAndFlush(argumentCaptor.capture());
        Employee capturedEmpl = argumentCaptor.getValue();

        employeeDalJPA.deleteEmployee(capturedEmpl.getEmployeeId());
        assertThat(capturedEmpl).isEqualTo(empl);
    }

    private Employee getValidEmployee()
    {
        Employee employee = new Employee("Kris",
                                         "Manager",
                                         "c",
                                         "password");

        return employee;
    }
}
