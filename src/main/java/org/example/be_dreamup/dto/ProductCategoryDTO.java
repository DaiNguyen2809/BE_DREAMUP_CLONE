package org.example.be_dreamup.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductCategoryDTO {
    @NotBlank(message = "Mã loại sản phẩm không được để trống")
    @Size(max = 100, message = "Mã loại sản phẩm tối đa 100 ký tự")
    private String productCategoryId;

    @NotBlank(message = "Tên loại sản phẩm không được để trống")
    @Size(max = 100, message = "Tên loại sản phẩm tối đa 100 ký tự")
    private String name;

    private String description;

   @Min(value = 0, message = "số lượng phải lớn hơn 0")
    private int quantity;
}
