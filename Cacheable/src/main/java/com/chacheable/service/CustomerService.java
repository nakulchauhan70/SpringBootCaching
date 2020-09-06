package com.chacheable.service;

import com.chacheable.model.Customer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CustomerService {

    @Cacheable(value = "customerInfoService")
    public List<Customer> getCustomer() {
        System.out.println("In getCustomer service");
        return Arrays.asList(new Customer(10, "Charlie Puth", "Current A/c", 10),
                new Customer(20, "Andrew Flintoff", "Saving A/c", 20)
        );
    }
}
