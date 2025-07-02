package org.example.be_dreamup.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class QuantityDTO {
    @NotBlank(message = "SKU không được để trống!")
    private String SKU;

    @Min(value = 0, message = "Số lượng không được âm!")
    private int quantity;
}
