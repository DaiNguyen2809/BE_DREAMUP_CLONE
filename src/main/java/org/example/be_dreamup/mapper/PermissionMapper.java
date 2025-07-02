package org.example.be_dreamup.mapper;

import org.example.be_dreamup.dto.PermissionDTO;
import org.example.be_dreamup.dto.PermissionResponseDTO;
import org.example.be_dreamup.model.Permission;
import org.springframework.stereotype.Component;

@Component
public class PermissionMapper {
    public Permission toEntity(PermissionDTO dto) {
        Permission entity = new Permission();
        entity.setName(dto.getName());
        return entity;
    }

    public void updateEntityFromDTO(PermissionDTO dto, Permission entity) {
        entity.setName(dto.getName());
    }

    public PermissionResponseDTO toResponseDTO(Permission entity) {
        PermissionResponseDTO dto = new PermissionResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
