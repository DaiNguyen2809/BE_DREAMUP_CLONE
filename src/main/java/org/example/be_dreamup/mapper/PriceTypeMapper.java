package org.example.be_dreamup.mapper;

import org.example.be_dreamup.dto.PriceTypeDTO;
import org.example.be_dreamup.dto.PriceTypeResponseDTO;
import org.example.be_dreamup.model.PriceType;
import org.springframework.stereotype.Component;

@Component
public class PriceTypeMapper {
    public void mapper (PriceType entity, PriceTypeDTO dto) {
        entity.setTypeId(dto.getTypeId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
    }

    public PriceType toEntity (PriceTypeDTO dto) {
        PriceType entity = new PriceType();
        mapper(entity, dto);
        return entity;
    }

    public void updateEntityFromDTO (PriceTypeDTO dto, PriceType entity) {
        mapper(entity, dto);
    }

    public PriceTypeResponseDTO toResponseDTO (PriceType entity) {
        PriceTypeResponseDTO dto = new PriceTypeResponseDTO();
        dto.setId(entity.getId());
        dto.setTypeId(entity.getTypeId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}
