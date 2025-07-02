package org.example.be_dreamup.service;

import org.example.be_dreamup.dto.CustomerCategoryDTO;
import org.example.be_dreamup.dto.CustomerCategoryResponseDTO;

import java.util.List;

public interface CustomerCategoryService {
    CustomerCategoryResponseDTO create(CustomerCategoryDTO dto);
    CustomerCategoryResponseDTO update(Long id, CustomerCategoryDTO dto);
    void delete(Long id);
    List<CustomerCategoryResponseDTO> getAll();
    CustomerCategoryResponseDTO getById(Long id);
}
