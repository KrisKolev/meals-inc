package com.example.restaurantapplication.security;


import com.example.restaurantapplication.model.Employee;
import com.example.restaurantapplication.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationEmployeeService implements UserDetailsService
{
    private final EmployeeService employeeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Employee employee = employeeService.findByUsername(username);

        if (employee == null)
        {
            throw new UsernameNotFoundException(username);
        }

        return new org.springframework.security.core.userdetails.User(employee.getEmployeeUsername(), employee.getEmployeePassword(), getAuthorities(employee.getEmployeeRole()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role)
    {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }
}
