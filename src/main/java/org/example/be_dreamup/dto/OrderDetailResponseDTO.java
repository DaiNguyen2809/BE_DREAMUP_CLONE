package org.example.be_dreamup.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDetailResponseDTO {
    private Long id;

    private String orderId;

    private String productId;

    private int quantity;

    private Long price;

    private Long discountPercentage;

    private Long discountAmount;

    private Long discountPrice;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
