package org.example.be_dreamup.service;


import org.example.be_dreamup.dto.QuantityDTO;
import org.example.be_dreamup.dto.QuantityResponseDTO;
import org.example.be_dreamup.model.Product;

import java.util.List;

public interface QuantityService {
    QuantityResponseDTO create (QuantityDTO dto, Product product);
    QuantityResponseDTO update (Long id, QuantityDTO dto, Product product);
    void delete (Long id);
    List<QuantityResponseDTO> getAll ();
    QuantityResponseDTO getById (Long id);
}
