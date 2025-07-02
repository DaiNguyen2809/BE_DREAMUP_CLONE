package org.example.be_dreamup.service;

import org.example.be_dreamup.dto.ProductCategoryDTO;
import org.example.be_dreamup.dto.ProductCategoryResponseDTO;

import java.util.List;

public interface ProductCategoryService {
    ProductCategoryResponseDTO create(ProductCategoryDTO dto);
    ProductCategoryResponseDTO update(Long id, ProductCategoryDTO dto);
    void delete(Long id);
    List<ProductCategoryResponseDTO> getAll();
    ProductCategoryResponseDTO getById(Long id);
}
