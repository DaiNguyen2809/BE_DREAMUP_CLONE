package org.example.be_dreamup.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddressResponseDTO {
    private Long id;

    private String street;

    private String ward;

    private String district;

    private String province;

    private LocalDateTime createdAt;

    private boolean isDefault;
}
