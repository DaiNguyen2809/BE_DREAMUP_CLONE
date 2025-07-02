package org.example.be_dreamup.service;

import org.example.be_dreamup.dto.ProductDTO;
import org.example.be_dreamup.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO create (ProductDTO dto);
    ProductResponseDTO update (String SKU, ProductDTO dto);
    void delete (String SKU);
    List<ProductResponseDTO> getAll();
    ProductResponseDTO getById (String SKU);
}
