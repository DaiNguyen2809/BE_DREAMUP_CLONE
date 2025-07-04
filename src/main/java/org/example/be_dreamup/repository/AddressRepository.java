package org.example.be_dreamup.repository;

import org.example.be_dreamup.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByIsDeletedFalse();
}
