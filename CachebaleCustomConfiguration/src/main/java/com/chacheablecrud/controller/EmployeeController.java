package com.chacheablecrud.controller;

import com.chacheablecrud.api.EmployeeService;
import com.chacheablecrud.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/Employee")
    public Employee addEmployee(@RequestBody Employee Employee){ return employeeService.addEmployee(Employee); }

    @PutMapping("/Employee")
    public Employee updateEmployee(@RequestBody Employee Employee) {
        return employeeService.updateEmployee(Employee);
    }

    @GetMapping("/Employee/{id}")
    public Employee getEmployee(@PathVariable long id){
        return employeeService.getEmployee(id);
    }

    @GetMapping("/Employee/getAll")
    public List<Employee> getAllEmployees(){ return employeeService.getAllEmployees(); }

    @DeleteMapping("/Employee/{id}")
    public String deleteEmployee(@PathVariable long id){
        return employeeService.deleteEmployee(id);
    }
}
