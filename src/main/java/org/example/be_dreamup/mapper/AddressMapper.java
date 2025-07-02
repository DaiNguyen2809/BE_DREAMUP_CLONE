package org.example.be_dreamup.mapper;

import org.example.be_dreamup.dto.AddressDTO;
import org.example.be_dreamup.dto.AddressResponseDTO;
import org.example.be_dreamup.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public void mapper(Address entity, AddressDTO dto) {
        entity.setStreet(dto.getStreet());
        entity.setWard(dto.getWard());
        entity.setDistrict(dto.getDistrict());
        entity.setProvince(dto.getProvince());
        entity.setDefault(dto.isDefault());
    }

    public Address toEntity(AddressDTO dto) {
        Address entity = new Address();
        mapper(entity, dto);
        return entity;
    }

    public void updateEntityFromDTO(AddressDTO dto, Address entity) {
        mapper(entity, dto);
    }

    public AddressResponseDTO toResponseDTO(Address entity) {
        AddressResponseDTO dto = new AddressResponseDTO();
        dto.setId(entity.getId());
        dto.setStreet(entity.getStreet());
        dto.setWard(entity.getWard());
        dto.setDistrict(entity.getDistrict());
        dto.setProvince(entity.getProvince());
        dto.setDefault(entity.isDefault());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }
}
