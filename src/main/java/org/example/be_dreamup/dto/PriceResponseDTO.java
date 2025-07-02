package org.example.be_dreamup.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PriceResponseDTO {
    private Long id;

    private List<String> productSKUs;

    private List<String> productNames;

    private List<String> priceTypeIds;

    private List<String> priceTypeNames;

    private Long price;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
