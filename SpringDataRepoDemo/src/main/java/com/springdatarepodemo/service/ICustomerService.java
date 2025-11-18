package com.springdatarepodemo.service;


import com.springdatarepodemo.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    List<Customer> findByNameContaining(String name);

    Customer findById(Long id);

    void save(Customer t);

    void remove(Long id);
}
