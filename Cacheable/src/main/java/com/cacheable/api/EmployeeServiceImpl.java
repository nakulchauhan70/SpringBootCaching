package com.cacheable.api;

import com.cacheable.dto.Employee;
import com.cacheable.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        logger.info("adding employee with empId");
        return employeeRepository.save(employee);
    }

    @Override
    @CachePut(cacheNames = "employees", key="#employee.empId")
    public Employee updateEmployee(Employee employee) {
        int i = employeeRepository.updateAddress(employee.getEmpId(), employee.getAddress());
        logger.info("Employee updated with new address");
        return employee;

//        Employee existingEmployee = employeeRepository.findById(employee.getEmpId()).get();
//        existingEmployee.setAddress(employee.getAddress());
//        Employee updatedEmployee = employeeRepository.save(existingEmployee);
//        return updatedEmployee;
    }

    @Override
    @Cacheable(cacheNames = "employees", key="#empId")      //key nme must be same with argument pass in method, eg. id in key and empId in method won't wor, either both should be id or empId
    public Employee getEmployee(long empId) {               //cacheNames must be same other wise we may lead with up expected response
        logger.info("fetching employee from db");
        Optional<Employee> employee = employeeRepository.findById(empId);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            return new Employee();
        }
    }

    @Override
    @Cacheable(cacheNames = "employees")
    public List<Employee> getAllEmployees() {
        logger.info("fetching all employees from db");
        return employeeRepository.findAll();
    }

    @Override
    @CacheEvict(cacheNames = "employees", key = "#empId")
    public String deleteEmployee(long empId) {
        employeeRepository.deleteById(empId);
        return "Employee deleted";
    }

}
