package org.example.be_dreamup.mapper;

import org.example.be_dreamup.dto.UserDTO;
import org.example.be_dreamup.dto.UserResponseDTO;
import org.example.be_dreamup.model.Role;
import org.example.be_dreamup.model.User;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public void mapper(UserDTO dto, User entity, Set<Role> roles) {
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setCreatedFrom(dto.getCreatedFrom());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setRoles(roles);
    }

    public User toEntity(UserDTO dto, Set<Role> roles) {
        User entity = new User();
        mapper(dto, entity, roles);
        return entity;
    }

    public void updateEntityFromDTO(UserDTO dto, User entity, Set<Role> roles) {
        mapper(dto, entity, roles);
    }

    public UserResponseDTO toResponseDTO(User entity) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setCreatedFrom(entity.getCreatedFrom());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setRoleIds(entity.getRoles().stream().map(Role::getId).collect(Collectors.toSet()));
        dto.setRoleNames(entity.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
        dto.setStatus(entity.getStatus().toString());
        return dto;
    }
}
