package org.example.be_dreamup.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.List;

@Data
public class PriceDTO {
    @NotEmpty(message = "Danh sách SKU sản phẩm không được để trống!")
    private List<String> productSKUs;

    @NotEmpty(message = "Danh sách mã chính sách giá không được để trống!")
    private List<String> priceTypeIds;

    @NotNull(message = "Giá không được để trống")
    @PositiveOrZero(message = "Giá phải lớn hơn hoặc bằng 0")
    private Long price;
}
