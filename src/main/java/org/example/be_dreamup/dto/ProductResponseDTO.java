package org.example.be_dreamup.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.be_dreamup.config.Grind;
import org.example.be_dreamup.config.RoastLevel;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductResponseDTO {
    private Long id;

    private String SKU;

    private String name;

    private String productCategoryId;

    private String description;

    private List<Grind> grinds;

    private String barcode;

    private Long weight;

    private Long unitWeightId;

    private String unitWeightName;

    private Long unitPackageId;

    private String unitPackageName;

    private List<RoastLevel> roastLevels;

    private String tags;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String image;

    private String image2;

    private String image3;

    private String image4;
}
