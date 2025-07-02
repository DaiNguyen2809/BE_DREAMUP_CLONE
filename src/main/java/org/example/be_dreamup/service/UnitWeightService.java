package org.example.be_dreamup.service;

import org.example.be_dreamup.dto.UnitWeightDTO;
import org.example.be_dreamup.dto.UnitWeightResponseDTO;
import org.example.be_dreamup.model.UnitWeight;
import org.example.be_dreamup.repository.UnitWeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UnitWeightService {
    UnitWeightResponseDTO create(UnitWeightDTO dto);
    UnitWeightResponseDTO update(Long id, UnitWeightDTO dto);
    void delete(Long id);
    List<UnitWeightResponseDTO> getAll();
    UnitWeightResponseDTO getById(Long id);
}
