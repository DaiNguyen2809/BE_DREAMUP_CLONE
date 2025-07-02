package org.example.be_dreamup.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDetailDTO {
    @NotBlank(message = "Mã đơn hàng không được để trống!")
    private String orderId;

    @NotBlank(message = "Mã sản phẩm không được để trống")
    private String productId;

    @NotNull(message = "Số lượng sản phẩm không được để trống!")
    @Size(max = 11, message = "Số lượng sản phẩm tối đa 11 ký tự!")
    @PositiveOrZero(message = "Số lượng sản phẩm >= 0")
    private int quantity;

    @NotNull(message = "Giá sản phẩm không được để trống!")
    @PositiveOrZero(message = "Giá sản phẩm >= 0")
    private Long price;

    @NotNull(message = "% giảm giá sản phẩm không được để trống!")
    @PositiveOrZero(message = "% giảm giá sản phẩm >= 0")
    private Long discountPercentage;

    @NotNull(message = "Giá trị giảm giá sản phẩm không được để trống!")
    @PositiveOrZero(message = "Giá trị giảm giá sản phẩm >= 0")
    private Long discountAmount;

    @NotNull(message = "Tổng giá trị giảm giá sản phẩm không được để trống!")
    @PositiveOrZero(message = "Tổng giá trị giảm giá sản phẩm >= 0")
    private Long discountPrice;

    @NotNull(message = "Ngày khởi tạo không được để trống!")
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
