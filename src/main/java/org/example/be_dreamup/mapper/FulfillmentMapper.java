package org.example.be_dreamup.mapper;

import org.example.be_dreamup.config.FulfillmentStatus;
import org.example.be_dreamup.dto.FulfillmentDTO;
import org.example.be_dreamup.dto.FulfillmentResponseDTO;
import org.example.be_dreamup.model.Fulfillment;
import org.example.be_dreamup.model.Order;
import org.springframework.stereotype.Component;

@Component
public class FulfillmentMapper {
    public void mapper(FulfillmentDTO dto, Fulfillment entity, Order order) {
        entity.setOrder(order);
        entity.setOrderDate(dto.getOrderDate());
        entity.setDescription(dto.getDescription());
        entity.setConfirmationDate(dto.getConfirmationDate());
        entity.setRejectedDate(dto.getRejectedDate());
        entity.setRequestedStaff(dto.getRequestStaffId());
        entity.setPackagedStaff(dto.getPackagedStaffId());
        entity.setRejectedStaff(dto.getRejectedStaffId());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setFulfillmentStatus(FulfillmentStatus.valueOf(dto.getFulfillmentStatus()));
    }

    public Fulfillment toEntity(FulfillmentDTO dto, Order order) {
        Fulfillment entity = new Fulfillment();
        mapper(dto, entity, order);
        return entity;
    }

    public void updateEntityFromDTO(FulfillmentDTO dto, Fulfillment entity, Order order) {
        mapper(dto, entity, order);
    }

    public FulfillmentResponseDTO toResponseDTO(Fulfillment entity) {
        FulfillmentResponseDTO dto = new FulfillmentResponseDTO();
        dto.setId(entity.getId());
        dto.setOrderId(entity.getOrder().getOrderId());
        dto.setOrderDate(entity.getOrderDate());
        dto.setDescription(entity.getDescription());
        dto.setConfirmationDate(entity.getConfirmationDate());
        dto.setRejectedDate(entity.getRejectedDate());
        dto.setRequestStaffId(entity.getRequestedStaff());
        dto.setPackagedStaffId(entity.getPackagedStaff());
        dto.setRejectedStaffId(entity.getRejectedStaff());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setFulfillmentStatus(entity.getFulfillmentStatus().toString());
        return dto;
    }
}
