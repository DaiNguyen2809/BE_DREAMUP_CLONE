package org.example.be_dreamup.mapper;

import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.config.DiscountType;
import org.example.be_dreamup.config.OrderStatus;
import org.example.be_dreamup.config.PaymentStatus;
import org.example.be_dreamup.dto.OrderDTO;
import org.example.be_dreamup.dto.OrderResponseDTO;
import org.example.be_dreamup.model.*;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {
    private final OrderDetailMapper orderDetailMapper;

    public void mapper(OrderDTO dto, Order entity, Customer customer, User staff, Payment paymentCategory, Set<OrderDetail> orderDetails) {
        entity.setOrderId(dto.getOrderId());
        entity.setCustomer(customer);
        entity.setStaff(staff);
        entity.setDiscountType(DiscountType.valueOf(dto.getDiscountType().toUpperCase()));
        entity.setDiscountAmount(dto.getDiscountAmount());
        entity.setSubTotal(dto.getSubtotal());
        entity.setTotal(dto.getTotal());
        entity.setDebt(dto.getDebt());
        entity.setCustomerPaid(dto.getCustomerPaid());
        entity.setShippingFee(dto.getShippingFee());
        entity.setSupportFee(dto.getSupportFee());
        entity.setNote(dto.getNote());
        entity.setTag(dto.getTag());
        entity.setOrderStatus(OrderStatus.valueOf(dto.getOrderStatus().toUpperCase()));
        entity.setPaymentStatus(PaymentStatus.valueOf(dto.getPaymentStatus().toUpperCase()));
        entity.setPaymentDate(dto.getPaymentDate());
        entity.setPaymentCategory(paymentCategory);
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setOrderDetails(orderDetails);
    }

    public Order toEntity(OrderDTO dto, Customer customer, User staff, Payment paymentCategory, Set<OrderDetail> orderDetails) {
        Order entity = new Order();
        mapper(dto, entity, customer, staff, paymentCategory, orderDetails);
        return entity;
    }

    public void updateEntityFromDTO(OrderDTO dto, Order entity, Customer customer, User staff, Payment paymentCategory, Set<OrderDetail> orderDetails) {
        mapper(dto, entity, customer, staff, paymentCategory, orderDetails);
    }

    public OrderResponseDTO toResponseDTO(Order entity, Set<OrderDetail> orderDetails) {
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setId(entity.getId());
        dto.setOrderId(entity.getOrderId());
        dto.setCustomer(entity.getCustomer());
        dto.setStaffId(entity.getStaff().getId());
        dto.setStaffName(entity.getStaff().getUsername());
        dto.setDiscountType(entity.getDiscountType().toString());
        dto.setDiscountAmount(entity.getDiscountAmount());
        dto.setSubtotal(entity.getSubTotal());
        dto.setTotal(entity.getTotal());
        dto.setDebt(entity.getDebt());
        dto.setCustomerPaid(entity.getCustomerPaid());
        dto.setShippingFee(entity.getShippingFee());
        dto.setSupportFee(entity.getSupportFee());
        dto.setNote(entity.getNote());
        dto.setTag(entity.getTag());
        dto.setOrderStatus(entity.getOrderStatus().toString());
        dto.setPaymentStatus(entity.getPaymentStatus().toString());
        dto.setPaymentDate(entity.getPaymentDate());
        dto.setPaymentCategoryId(entity.getPaymentCategory().getId());
        dto.setPaymentCategoryName(entity.getPaymentCategory().getName());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setOrderDetails(orderDetails.stream().map(orderDetailMapper::toResponseDTO).collect(Collectors.toSet()));
        return dto;
    }
}
