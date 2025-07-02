package org.example.be_dreamup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.be_dreamup.config.Gender;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, unique = true, nullable = false)
    private String customerId;

    @Column(length = 100, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_category", nullable = false)
    private CustomerCategory customerCategory;

    @Column(length = 10, nullable = false)
    private String phone;

    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses = new ArrayList<>();

    private String description;

    @Column(length = 100)
    private String tag;

    private Long debt = 0L;

    @Column(nullable = false)
    private Long totalExpenditures = 0L;

    @Column(nullable = false)
    private Long totalOrders = 0L;

    @Column(nullable = false)
    private Long totalProducts = 0L;

    @Column(nullable = false)
    private Long totalReturnProducts = 0L;

    @Column(nullable = false)
    private Long point = 0L;

    @Column(length = 500)
    private String affiliate;

    @Column(length = 500)
    private String specialCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private boolean isDeleted = false;
}
