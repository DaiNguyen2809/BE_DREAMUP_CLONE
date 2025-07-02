package org.example.be_dreamup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.be_dreamup.config.Grind;
import org.example.be_dreamup.config.RoastLevel;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, unique = true, nullable = false)
    private String SKU;

    @Column(length = 100 , nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category", nullable = false)
    private ProductCategory category;

    private String description;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Grind> grinds;

    @Column(length = 100, nullable = false, unique = true)
    private String barcode;

    @Column(nullable = false)
    private Long weight = 0L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_weight")
    private UnitWeight unitWeight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_package")
    private UnitPackage unitPackage;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<RoastLevel> roastLevels;

    @Column(length = 300)
    private String tags;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private String image;

    private String image2;

    private String image3;

    private String image4;

    private boolean isDeleted = false;
}
