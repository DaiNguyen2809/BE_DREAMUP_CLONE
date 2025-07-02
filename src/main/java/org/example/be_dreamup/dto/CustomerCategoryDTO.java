package org.example.be_dreamup.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerCategoryDTO {
    @NotBlank(message = "Mã loại khách hàng không được để trống")
    @Size(max = 100, message = "Mã loại khách hàng tối đa 100 ký tự")
    private String customerCategoryId;

    @NotBlank(message = "Tên loại khách hàng không được để trống")
    @Size(max = 100, message = "Tên loại khách hàng tối đa 100 ký tự ")
    private String name;

    private String description;

    @Size(max = 20, message = "Chính sách giá tối đa 20 ký tự")
    private String priceTypeId;

    @Min(value = 0, message = "Phần trăm giảm giá phải >= 0")
    private int discountPercentage;

    private Long paymentCat;
}
