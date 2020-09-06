package com.chacheable.controller;

import com.chacheable.model.Customer;
import com.chacheable.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

	@Autowired
    CustomerService customerService;

    @RequestMapping("/customerinfo")
    @Cacheable(value = "customerInfo")
    public List<Customer> customerInformation() {
        System.out.println("customer information from cache");
        List<Customer> detail = Arrays.asList(new Customer(5126890, "Charlie Puth", "Current A/c", 450000.00),
                new Customer(7620015, "Andrew Flintoff", "Saving A/c", 210089.00)
        );
        return detail;
    }

    @RequestMapping("/customerinfoservice")
    public List<Customer> customerInformationService() {
    	//make sure to Autowire customerService, otherwise it won't work
		/*Autowire and Component from CustomerService are mandatory other wise it will throw
		Null pointer exception(if use only Autowire) or Cache won't work(if use Component)*/
        return customerService.getCustomer();
    }
}
