package org.example.be_dreamup.repository;

import org.example.be_dreamup.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderId(String orderId);
    List<Order> findByIsDeletedFalse();
}
