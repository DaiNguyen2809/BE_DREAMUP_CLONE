package org.example.be_dreamup.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PriceTypeResponseDTO {
    private Long id;

    private String typeId;

    private String name;

    private String description;

    private LocalDateTime createdAt;
}
