package org.example.be_dreamup.service;

import org.example.be_dreamup.dto.UnitPackageDTO;
import org.example.be_dreamup.dto.UnitPackageResponseDTO;

import java.util.List;

public interface UnitPackageService {
   UnitPackageResponseDTO create(UnitPackageDTO dto);
   UnitPackageResponseDTO update(Long id, UnitPackageDTO dto);
   void delete(Long id);
   List<UnitPackageResponseDTO> getAll();
   UnitPackageResponseDTO getById(Long id);
}
