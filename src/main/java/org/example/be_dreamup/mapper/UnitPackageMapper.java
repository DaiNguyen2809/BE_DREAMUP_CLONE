package org.example.be_dreamup.mapper;

import org.example.be_dreamup.dto.UnitPackageDTO;
import org.example.be_dreamup.dto.UnitPackageResponseDTO;
import org.example.be_dreamup.model.UnitPackage;
import org.springframework.stereotype.Component;

@Component
public class UnitPackageMapper {
    public UnitPackage toEntity(UnitPackageDTO dto) {
        UnitPackage entity = new UnitPackage();
        entity.setPackageId(dto.getPackageId());
        entity.setName(dto.getName());
        return entity;
    }

    public void updateEntityFromDTO(UnitPackageDTO dto, UnitPackage entity) {
        entity.setPackageId(dto.getPackageId());
        entity.setName(dto.getName());
    }

    public UnitPackageResponseDTO toResponseDTO(UnitPackage entity) {
        UnitPackageResponseDTO dto = new UnitPackageResponseDTO();
        dto.setId(entity.getId());
        dto.setPackageId(entity.getPackageId());
        dto.setName(entity.getName());
        return dto;
    }
}
