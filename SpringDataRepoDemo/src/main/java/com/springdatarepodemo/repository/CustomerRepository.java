package com.springdatarepodemo.repository;

import com.springdatarepodemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    void removeById(Long id);
    // action: remove, find, delete,... by (bởi cái gì)...các điều kiện thêm
//    List<Customer> findAllByNameContaining(String name);
    List<Customer> findAllByNameAndEmail(String name, String email);

    @Query(value = "select * from customer where name like '%' :name '%'", nativeQuery = true)
    List<Customer> findAllCustom(@Param("name") String name);
}
