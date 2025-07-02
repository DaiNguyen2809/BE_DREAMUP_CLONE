package org.example.be_dreamup.dto;

import lombok.Data;

@Data
public class QuantityResponseDTO {
    private Long id;

    private String SKU;

    private String productName;

    private int quantity;
}
