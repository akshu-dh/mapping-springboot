package com.mapping.service;

import com.mapping.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAllEmployees();

    public ResponseEntity<Employee> findEmployeeById(Long id);

    public Employee saveEmployee(Employee employee);

    public ResponseEntity<Employee> deleteEmployee(Long id);

    public Employee updateEmployee(Long id, Employee newEmployee);
}
