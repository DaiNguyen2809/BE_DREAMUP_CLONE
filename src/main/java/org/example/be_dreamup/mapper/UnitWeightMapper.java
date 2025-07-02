package org.example.be_dreamup.mapper;

import org.example.be_dreamup.dto.UnitWeightDTO;
import org.example.be_dreamup.dto.UnitWeightResponseDTO;
import org.example.be_dreamup.model.UnitWeight;
import org.springframework.stereotype.Component;

@Component
public class UnitWeightMapper {
    public UnitWeight toEntity(UnitWeightDTO dto) {
        UnitWeight entity = new UnitWeight();
        entity.setName(dto.getName());
        return entity;
    }

    public void updateEntityFromDTO(UnitWeightDTO dto, UnitWeight entity) {
        entity.setName(dto.getName());
    }

    public UnitWeightResponseDTO toResponseDTO(UnitWeight entity) {
        UnitWeightResponseDTO dto = new UnitWeightResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
