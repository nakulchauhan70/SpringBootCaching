package com.cacheable.controller;

import com.cacheable.api.EmployeeService;
import com.cacheable.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/Employee")
    public Employee addEmployee(@RequestBody Employee Employee) {
        return employeeService.addEmployee(Employee);
    }

    @PutMapping("/Employee")
    public Employee updateEmployee(@RequestBody Employee Employee) {
        return employeeService.updateEmployee(Employee);
    }

    @GetMapping("/Employee/{id}")
    public Employee getEmployee(@PathVariable long id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/Employee/getAll")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/Employee/{id}")
    public String deleteEmployee(@PathVariable long id) {
        return employeeService.deleteEmployee(id);
    }

    //make sure to Autowired customerService, otherwise it won't work
    /*Autowired and Component from CustomerService are mandatory other wise it will throw
    Null pointer exception(if use only Autowired) or Cache won't work(if use Component)*/
}
