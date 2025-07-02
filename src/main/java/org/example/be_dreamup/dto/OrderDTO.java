package org.example.be_dreamup.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class OrderDTO {
    @NotBlank(message = "Mã đơn hàng không được để trống!")
    @Size(max = 100, message = "Mã đơn hàng tối đa 100 ký tự!")
    private String orderId;

    @NotBlank(message = "Mã khách hàng không được để trống!")
    private String customerId;

    @NotBlank(message = "Mã nhân viên không được để trống!")
    private String staffId;

    @NotBlank(message = "Loại giảm giá không được để trống!")
    private String discountType;

    @NotNull(message = "Giá trị giảm giá không được để trống!")
    @PositiveOrZero(message = "Giá trị giảm giá >= 0")
    private Long discountAmount;

    @NotNull(message = "Giá trị trước giảm giá không được để trống!")
    @PositiveOrZero(message = "Giá trị trước giảm giá >= 0")
    private Long subtotal;

    @NotNull(message = "Giá trị sau giá không được để trống!")
    @PositiveOrZero(message = "Giá trị sau giá >= 0")
    private Long total;

    @NotNull(message = "Số tiền khách nợ không được để trống!")
    @PositiveOrZero(message = "Số tiền khách nợ >= 0")
    private Long debt;

    @NotNull(message = "Số tiền khách đã trả không được để trống!")
    @PositiveOrZero(message = "Số tiền khách đã trả >= 0")
    private Long customerPaid;

    @NotNull(message = "Tiền ship không được để trống!")
    @PositiveOrZero(message = "Tiền ship khách nợ >= 0")
    private Long shippingFee;

    @NotNull(message = "Số tiền hỗ trợ khách không được để trống!")
    @PositiveOrZero(message = "Số tiền hỗ trợ khách >= 0")
    private Long supportFee;

    @Size(max = 500, message = "Ghi chú đơn hàng tối đa 500 ký tự!")
    private String note;

    private String tag;

    @NotBlank(message = "Trạng thái đơn hàng không được để trống!")
    private String orderStatus;

    @NotBlank(message = "Trạng thái thanh toán không được để trống!")
    private String paymentStatus;

    private LocalDateTime paymentDate;

    @NotNull(message = "Phương thức thanh toán không được để trống!")
    private Long paymentCategoryId;

    @NotNull(message = "Ngày khởi tạo không được để trống!")
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Set<OrderDetailDTO> orderDetails;
}
