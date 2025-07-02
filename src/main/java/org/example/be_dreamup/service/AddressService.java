package org.example.be_dreamup.service;

import org.example.be_dreamup.dto.AddressDTO;
import org.example.be_dreamup.dto.AddressResponseDTO;

import java.util.List;


public interface AddressService {
    AddressResponseDTO create(AddressDTO address);

    AddressResponseDTO update(Long id, AddressDTO address);

    void delete(Long id);

    List<AddressResponseDTO> getAll();

    AddressResponseDTO getById(Long id);

    void changeAddressStatusToUnDefault(Long id);

    void changeAddressStatusToDefault(Long id);
}