package org.example.be_dreamup.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FulfillmentResponseDTO {
    private Long id;

    private String orderId;

    private LocalDateTime orderDate;

    private String description;

    private LocalDateTime confirmationDate;

    private LocalDateTime rejectedDate;

    private String requestStaffId;

    private String packagedStaffId;

    private String rejectedStaffId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String fulfillmentStatus;
}
