package org.example.be_dreamup.mapper;

import org.example.be_dreamup.dto.OrderDetailDTO;
import org.example.be_dreamup.dto.OrderDetailResponseDTO;
import org.example.be_dreamup.model.Order;
import org.example.be_dreamup.model.OrderDetail;
import org.example.be_dreamup.model.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailMapper {
    public void mapper(OrderDetailDTO dto, OrderDetail entity, Order order, Product product) {
        entity.setOrder(order);
        entity.setProduct(product);
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(dto.getPrice());
        entity.setDiscountPercentage(dto.getDiscountPercentage());
        entity.setDiscountAmount(dto.getDiscountAmount());
        entity.setDiscountPrice(dto.getDiscountPrice());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
    }

    public OrderDetail toEntity(OrderDetailDTO dto, Order order, Product product) {
        OrderDetail entity = new OrderDetail();
        mapper(dto, entity, order, product);
        return entity;
    }

    public void updateEntityFromDTO(OrderDetailDTO dto, OrderDetail entity, Order order, Product product) {
        mapper(dto, entity, order, product);
    }

    public OrderDetailResponseDTO toResponseDTO(OrderDetail entity) {
        OrderDetailResponseDTO dto = new OrderDetailResponseDTO();
        dto.setId(entity.getId());
        dto.setOrderId(entity.getOrder().getOrderId());
        dto.setProductId(entity.getProduct().getSKU());
        dto.setQuantity(entity.getQuantity());
        dto.setPrice(entity.getPrice());
        dto.setDiscountPercentage(entity.getDiscountPercentage());
        dto.setDiscountAmount(entity.getDiscountAmount());
        dto.setDiscountPrice(entity.getDiscountPrice());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}
