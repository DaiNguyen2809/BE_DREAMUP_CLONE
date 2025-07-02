package org.example.be_dreamup.service;


import org.example.be_dreamup.dto.PermissionDTO;
import org.example.be_dreamup.dto.PermissionResponseDTO;

import java.util.List;

public interface PermissionService {
   PermissionResponseDTO create(PermissionDTO dto);
   PermissionResponseDTO update(Long id, PermissionDTO dto);
   void delete(Long id);
   List<PermissionResponseDTO> getAll();
   PermissionResponseDTO getById(Long id);
}
