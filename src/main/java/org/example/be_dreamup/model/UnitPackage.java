package org.example.be_dreamup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "unit_packages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, unique = true, nullable = false)
    private String packageId;

    @Column(length = 100, nullable = false)
    private String name;

    private boolean isDeleted = false;
}
