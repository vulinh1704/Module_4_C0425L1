package com.jpa_demo.repository;

import com.jpa_demo.entity.Customer;

import java.util.List;

public interface ICustomerRepository{
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer t);

    void remove(Long id);
}
