package org.example.be_dreamup.service;

import org.example.be_dreamup.dto.PriceDTO;
import org.example.be_dreamup.dto.PriceResponseDTO;
import org.example.be_dreamup.model.PriceType;
import org.example.be_dreamup.model.Product;

import java.util.List;

public interface PriceService {
    PriceResponseDTO create (PriceDTO dto, List<Product> products, List<PriceType> priceTypes);
    PriceResponseDTO update(Long id, PriceDTO dto, List<Product> products, List<PriceType> priceTypes);
    void delete(Long id);
    List<PriceResponseDTO> getAll();
    PriceResponseDTO getById(Long id);
}
