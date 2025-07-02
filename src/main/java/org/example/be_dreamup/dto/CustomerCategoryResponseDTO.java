package org.example.be_dreamup.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerCategoryResponseDTO {
    private Long id;

    private String customerCategoryId;

    private String name;

    private String description;

    private int quantity;

    private String priceTypeId;

    private int discountPercentage;

    private Long paymentCat;

    private LocalDateTime createdAt;
}
