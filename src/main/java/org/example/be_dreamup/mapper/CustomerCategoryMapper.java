package org.example.be_dreamup.mapper;

import org.example.be_dreamup.dto.CustomerCategoryDTO;
import org.example.be_dreamup.dto.CustomerCategoryResponseDTO;
import org.example.be_dreamup.model.CustomerCategory;
import org.springframework.stereotype.Component;

@Component
public class CustomerCategoryMapper {
    public void mapper(CustomerCategoryDTO dto, CustomerCategory entity) {
        entity.setCustomerCategoryId(dto.getCustomerCategoryId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPriceTypeId(dto.getPriceTypeId());
        entity.setDiscountPercentage(dto.getDiscountPercentage());
        entity.setPaymentCat(dto.getPaymentCat());
    }

    public CustomerCategory toEntity(CustomerCategoryDTO dto) {
        CustomerCategory entity = new CustomerCategory();
        mapper(dto, entity);
        return entity;
    }

    public void updateEntityFromDTO(CustomerCategoryDTO dto, CustomerCategory entity) {
        mapper(dto, entity);
    }

    public CustomerCategoryResponseDTO toResponseDTO(CustomerCategory entity) {
        CustomerCategoryResponseDTO dto = new CustomerCategoryResponseDTO();
        dto.setId(entity.getId());
        dto.setCustomerCategoryId(entity.getCustomerCategoryId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setQuantity(entity.getQuantity());
        dto.setPriceTypeId(entity.getPriceTypeId());
        dto.setDiscountPercentage(entity.getDiscountPercentage());
        dto.setPaymentCat(entity.getPaymentCat());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}
