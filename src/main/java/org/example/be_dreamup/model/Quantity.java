package org.example.be_dreamup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quantities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SKU", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int quantity = 0;

    private boolean isDeleted = false;
}
