package org.example.be_dreamup.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class UserDTO {
    @NotBlank(message = "Tên đăng nhập không được để trống!")
    private String username;

    @NotBlank(message = "Mật khẩu không được để trống!")
    private String password;

    @NotBlank(message = "Email không được để trống!")
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống!")
    @Size(max = 10, message = "Số điện thoại tối đa 10 ký tự!")
    private String phone;

    @NotBlank(message = "Nguồn tạo tài khoản không được để trống!")
    private String createdFrom;

    @NotNull(message = "Ngày khởi tạo không được để trống!")
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Set<Long> roleIds;
}
