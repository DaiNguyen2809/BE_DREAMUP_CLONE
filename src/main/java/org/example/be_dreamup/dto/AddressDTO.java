package org.example.be_dreamup.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddressDTO {
    @NotBlank(message = "Địa chỉ không được để trống!")
    private String street;

    @NotBlank(message = "Phường/Xã không được để trống!")
    private String ward;

    @NotBlank(message = "Quận/Huyện không được để trống!")
    private String district;

    @NotBlank(message = "Tỉnh/Thành không được để trống")
    private String province;

    private boolean isDefault;
}
