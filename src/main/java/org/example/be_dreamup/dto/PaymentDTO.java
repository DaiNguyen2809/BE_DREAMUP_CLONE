package org.example.be_dreamup.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PaymentDTO {
    @NotBlank(message = "Tên phương thức thanh toán không được để trống!")
    @Size(max = 100, message = "Tên phương thức tối đa 100 ký tự!")
    private String name;
}
