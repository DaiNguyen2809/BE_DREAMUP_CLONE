package org.example.be_dreamup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.be_dreamup.config.DiscountType;
import org.example.be_dreamup.config.OrderStatus;
import org.example.be_dreamup.config.PaymentStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, unique = true, nullable = false)
    private String orderId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer", nullable = false)
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff", nullable = false)
    private User staff;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DiscountType discountType = DiscountType.PERCENTAGE;

    @Column(nullable = false)
    private Long discountAmount = 0L;

    @Column(nullable = false)
    private Long subTotal = 0L;

    @Column(nullable = false)
    private Long total = 0L;

    @Column(nullable = false)
    private Long debt = 0L;

    @Column(nullable = false)
    private Long customerPaid = 0L;

    @Column(nullable = false)
    private Long shippingFee = 0L;

    @Column(nullable = false)
    private Long supportFee = 0L;

    @Column(length = 500)
    private String note;

    private String tag;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paymentStatus;

    private LocalDateTime paymentDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_category")
    private Payment paymentCategory;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails;

    private boolean isDeleted = false;
}
