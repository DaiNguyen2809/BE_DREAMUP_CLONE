package org.example.be_dreamup.repository;

import org.example.be_dreamup.model.UnitPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitPackageRepository extends JpaRepository<UnitPackage, Long> {
    List<UnitPackage> findByIsDeletedFalse();
}
