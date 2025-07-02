package org.example.be_dreamup.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class RoleDTO {
    @NotBlank(message = "Tên quyền không được để trống!")
    @Size(max = 100, message = "Tên quyền tối đa 100 ký tự!")
    private String name;

    @Size(max = 300, message = "Ghi chú quyền người dùng tối đa 300 ký tự!")
    private String note;

    private Set<Long> permissionIds;
}
