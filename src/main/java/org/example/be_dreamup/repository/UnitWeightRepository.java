package org.example.be_dreamup.repository;

import org.example.be_dreamup.model.UnitWeight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitWeightRepository extends JpaRepository<UnitWeight, Long> {
    List<UnitWeight> findByIsDeletedFalse();
}
