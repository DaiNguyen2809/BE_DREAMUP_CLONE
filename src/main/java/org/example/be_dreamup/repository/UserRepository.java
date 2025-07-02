package org.example.be_dreamup.repository;

import org.example.be_dreamup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByIsDeletedFalse();
    User findByUsername(String username);
}
