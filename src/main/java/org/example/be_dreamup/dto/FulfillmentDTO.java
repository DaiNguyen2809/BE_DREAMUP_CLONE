package org.example.be_dreamup.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FulfillmentDTO {
    @NotBlank(message = "Mã đơn hàng không được để trống!")
    private String orderId;

    @NotNull(message = "Ngày yêu cầu đóng gói không được để trống!")
    private LocalDateTime orderDate;

    private String description;

    private LocalDateTime confirmationDate;

    private LocalDateTime rejectedDate;

    @Size(max = 100, message = "Nhân viên yêu cầu tối đa 100 ký tự!")
    private String requestStaffId;

    @Size(max = 100, message = "Nhân viên đóng gói tối đa 100 ký tự!")
    private String packagedStaffId;

    @Size(max = 100, message = "Nhân viên hủy đóng gói tối đa 100 ký tự!")
    private String rejectedStaffId;

    @NotNull(message = "Ngày khởi tạo không được để trống!")
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NotBlank(message = "Trạng thái đóng gói không được để trống!")
    private String fulfillmentStatus;
}
