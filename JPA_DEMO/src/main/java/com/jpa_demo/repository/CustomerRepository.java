package com.jpa_demo.repository;

import com.jpa_demo.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
//import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
//@Repository
public class CustomerRepository implements ICustomerRepository { // Viết các function để tương tác với db
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c", Customer.class); // HQL
        return query.getResultList();
    }
    // findAll()

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.id=:id", Customer.class); // HQL
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    // findById(Long id);

    @Override
    public void save(Customer customer) {
        if(customer.getId() == null) {
            entityManager.persist(customer);
        } else {
            entityManager.merge(customer);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }
}