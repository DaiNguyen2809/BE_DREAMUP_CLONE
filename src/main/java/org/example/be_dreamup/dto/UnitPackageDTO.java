package org.example.be_dreamup.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UnitPackageDTO {
    @NotBlank(message = "Mã đơn vị đóng gói không được để trống!")
    @Size(max = 100, message = "Mã đơn vị đóng gói tối đa 100 ký tự!")
    private String packageId;

    @NotBlank(message = "Tên mã đơn vị đóng gói không được để trống!")
    @Size(max = 100, message = "Tên mã đơn vị đóng gói tối đa 100 ký tự!")
    private String name;
}
