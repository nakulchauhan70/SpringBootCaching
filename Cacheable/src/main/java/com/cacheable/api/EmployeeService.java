package com.cacheable.api;


import com.cacheable.dto.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee Employee);

    Employee updateEmployee(Employee Employee);

    Employee getEmployee(long id);

//    List<Employee> getAllEmployees();

    String deleteEmployee(long id);
}
