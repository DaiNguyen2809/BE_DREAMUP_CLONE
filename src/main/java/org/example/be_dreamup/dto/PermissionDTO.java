package org.example.be_dreamup.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PermissionDTO {
    @NotBlank(message = "Tên phân quyền không được để trống!")
    @Size(max = 100, message = "Tên phân quyền tối đa 100 ký tự!")
    private String name;
}
