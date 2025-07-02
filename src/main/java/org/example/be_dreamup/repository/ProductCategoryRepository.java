package org.example.be_dreamup.repository;

import org.example.be_dreamup.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    List<ProductCategory> findByIsDeletedFalse();
    ProductCategory findByProductCategoryId(String productCategoryId);
}
