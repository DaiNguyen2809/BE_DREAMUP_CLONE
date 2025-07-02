package org.example.be_dreamup.repository;

import org.example.be_dreamup.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByIsDeletedFalse();
}
