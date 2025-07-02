package org.example.be_dreamup.repository;

import org.example.be_dreamup.model.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuantityRepository extends JpaRepository<Quantity, Long> {
    List<Quantity> findByIsDeletedFalse();
}
