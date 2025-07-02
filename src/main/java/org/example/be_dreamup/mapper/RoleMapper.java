package org.example.be_dreamup.mapper;

import org.example.be_dreamup.dto.RoleDTO;
import org.example.be_dreamup.dto.RoleResponseDTO;
import org.example.be_dreamup.model.Permission;
import org.example.be_dreamup.model.Role;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class RoleMapper {
    public Role toEntity(RoleDTO dto, Set<Permission> permissions) {
        Role entity = new Role();
        entity.setName(dto.getName());
        entity.setNote(dto.getNote());
        entity.setPermissions(permissions);
        return entity;
    }

    public void updateEntityFromDTO(RoleDTO dto, Role entity, Set<Permission> permissions) {
        entity.setName(dto.getName());
        entity.setNote(dto.getNote());
        entity.setPermissions(permissions);
    }

    public RoleResponseDTO toResponseDTO(Role entity) {
        RoleResponseDTO dto = new RoleResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setNote(entity.getNote());
        dto.setPermissionIds(entity.getPermissions().stream().map(Permission::getId).collect(Collectors.toSet()));
        dto.setPermissionNames(entity.getPermissions().stream().map(Permission::getName).collect(Collectors.toSet()));
        return dto;
    }
}
