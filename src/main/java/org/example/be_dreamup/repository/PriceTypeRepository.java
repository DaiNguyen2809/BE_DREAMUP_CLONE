package org.example.be_dreamup.repository;

import org.example.be_dreamup.model.PriceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceTypeRepository extends JpaRepository<PriceType, Long> {
    List<PriceType> findByIsDeletedFalse();
    PriceType findByTypeId(String typeId);
}
