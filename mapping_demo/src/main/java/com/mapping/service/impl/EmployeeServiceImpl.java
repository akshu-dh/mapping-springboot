package com.mapping.service.impl;

import com.mapping.entity.Employee;
import com.mapping.repository.EmployeeRepository;
import com.mapping.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    public ResponseEntity<Employee> findEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return ResponseEntity.ok().body(employee.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public ResponseEntity<Employee> deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
            return ResponseEntity.ok().body(employee.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public Employee updateEmployee(Long id, Employee newEmployee) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(data -> {
            data.setEmp_name(newEmployee.getEmp_name());
            return employeeRepository.save(data);
        }).orElseGet(() -> {
            newEmployee.setEmp_id(id);
            return employeeRepository.save(newEmployee);
        });

    }
}
