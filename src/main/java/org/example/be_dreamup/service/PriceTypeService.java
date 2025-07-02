package org.example.be_dreamup.service;

import org.example.be_dreamup.dto.PriceTypeDTO;
import org.example.be_dreamup.dto.PriceTypeResponseDTO;

import java.util.List;

public interface PriceTypeService {
    PriceTypeResponseDTO create (PriceTypeDTO dto);
    PriceTypeResponseDTO update(String typeId, PriceTypeDTO dto);
    void delete(String typeId);
    List<PriceTypeResponseDTO> getAll();
    PriceTypeResponseDTO getByTypeId(String typeId);
}
