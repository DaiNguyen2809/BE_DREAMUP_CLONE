package org.example.be_dreamup.repository;

import org.example.be_dreamup.model.CustomerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerCategoryRepository extends JpaRepository<CustomerCategory, Long> {
    List<CustomerCategory> findByIsDeletedFalse();

}
