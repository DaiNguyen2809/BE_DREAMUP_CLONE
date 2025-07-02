package org.example.be_dreamup.repository;

import org.example.be_dreamup.model.Fulfillment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FulfillmentRepository extends JpaRepository<Fulfillment, Long> {

}
