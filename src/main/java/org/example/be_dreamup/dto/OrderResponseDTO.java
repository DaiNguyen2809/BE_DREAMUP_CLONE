package org.example.be_dreamup.dto;

import lombok.Data;
import org.example.be_dreamup.model.Customer;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class OrderResponseDTO {
    private Long id;

    private String orderId;

    private Customer customer;

    private Long staffId;

    private String staffName;

    private String discountType;

    private Long discountAmount;

    private Long subtotal;

    private Long total;

    private Long debt;

    private Long customerPaid;

    private Long shippingFee;

    private Long supportFee;

    private String note;

    private String tag;

    private String orderStatus;

    private String paymentStatus;

    private LocalDateTime paymentDate;

    private Long paymentCategoryId;

    private String paymentCategoryName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Set<OrderDetailResponseDTO> orderDetails;
}
