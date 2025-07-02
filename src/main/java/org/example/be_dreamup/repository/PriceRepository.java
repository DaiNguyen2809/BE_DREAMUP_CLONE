package org.example.be_dreamup.repository;

import org.example.be_dreamup.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    List<Price> findByIsDeletedFalse();
}
