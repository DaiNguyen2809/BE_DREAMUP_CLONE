package org.example.be_dreamup.repository;

import org.example.be_dreamup.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByIsDeletedFalse();
    Product findBySKU(String SKU);
}
