package org.example.be_dreamup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer_categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class CustomerCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String customerCategoryId;

    @Column(length = 100, nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private int quantity = 0;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(length = 20)
    private String priceTypeId = "retail";

    private int discountPercentage = 0;

    // dung de so sanh neu co payment_cat thi set payment khong thi chon
    private Long paymentCat = 0L;

    private boolean isDeleted = false;
}
