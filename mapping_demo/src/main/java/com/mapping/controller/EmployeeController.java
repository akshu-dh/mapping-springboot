package com.mapping.controller;

import com.mapping.entity.Employee;
import com.mapping.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // for listing all the students
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @PostMapping
    public Employee createStudent(@RequestBody Employee employee) {

        return employeeService.saveEmployee(employee);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id) {
        return employeeService.findEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteStudent(@PathVariable(value = "id") Long id) {
        return employeeService.deleteEmployee(id);
    }
}
