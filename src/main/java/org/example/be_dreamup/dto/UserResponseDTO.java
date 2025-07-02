package org.example.be_dreamup.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class UserResponseDTO {
    private Long id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String createdFrom;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Set<Long> roleIds;

    private Set<String> roleNames;

    private String status;
}
