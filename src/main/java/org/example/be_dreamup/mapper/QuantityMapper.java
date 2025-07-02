package org.example.be_dreamup.mapper;

import org.example.be_dreamup.dto.QuantityDTO;
import org.example.be_dreamup.dto.QuantityResponseDTO;
import org.example.be_dreamup.model.Product;
import org.example.be_dreamup.model.Quantity;
import org.springframework.stereotype.Component;

@Component
public class QuantityMapper {
    public void mapper(Quantity entity, QuantityDTO dto, Product product) {
        entity.setProduct(product);
        entity.setQuantity(dto.getQuantity());
    }

    public Quantity toEntity(QuantityDTO dto, Product product) {
        Quantity entity = new Quantity();
        mapper(entity, dto, product);
        return entity;
    }

    public void updateEntityFromDTO(QuantityDTO dto, Quantity entity, Product product) {
        mapper(entity, dto, product);
    }

    public QuantityResponseDTO toResponseDTO(Quantity entity) {
        QuantityResponseDTO dto = new QuantityResponseDTO();
        dto.setId(entity.getId());
        dto.setSKU(entity.getProduct().getSKU());
        dto.setProductName(entity.getProduct().getName());
        dto.setQuantity(entity.getQuantity());
        return dto;
    }
}
