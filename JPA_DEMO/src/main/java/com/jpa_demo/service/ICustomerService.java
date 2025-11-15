package com.jpa_demo.service;

import com.jpa_demo.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer t);

    void remove(Long id);
}
