package org.example.be_dreamup.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductCategoryResponseDTO {
    private Long id;

    private String productCategoryId;

    private String name;

    private String description;

    private int quantity;

    private LocalDateTime createdAt;
}
