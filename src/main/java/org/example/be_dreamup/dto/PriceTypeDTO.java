package org.example.be_dreamup.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PriceTypeDTO {
    @NotBlank(message = "Mã chính sách giá không được để trống!")
    @Size(max = 20, message = "Mã chính sách giá tối đa 20 ký tự!")
    private String typeId;

    @NotBlank(message = "Tên chính sách giá không được để trống!")
    @Size(max = 100, message = "Tên chính sách giá tối đa 100 ký tự!")
    private String name;

    private String description;
}
