package org.example.be_dreamup.repository;

import org.example.be_dreamup.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByIsDeletedFalse();
    Customer findByCustomerId(String customerId);
}
