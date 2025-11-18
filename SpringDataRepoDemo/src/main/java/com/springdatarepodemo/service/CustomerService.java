package com.springdatarepodemo.service;

import com.springdatarepodemo.entity.Customer;
import com.springdatarepodemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public List<Customer> findByNameContaining(String name) {
        return customerRepository.findAllCustom(name);
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerOptional.get();
    }

    @Override
    public void save(Customer t) {
        customerRepository.save(t);
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        customerRepository.delete(customer);
    }

}