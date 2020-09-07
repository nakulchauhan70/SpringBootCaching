package com.cacheable.redis.controller;

import com.cacheable.redis.api.EmployeeService;
import com.cacheable.redis.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-management")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee Employee) {
        return employeeService.addEmployee(Employee);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee Employee) {
        return employeeService.updateEmployee(Employee);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable long id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/employee/getAll")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable long id) {
        return employeeService.deleteEmployee(id);
    }

}
