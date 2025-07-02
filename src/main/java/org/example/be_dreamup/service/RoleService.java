package org.example.be_dreamup.service;


import org.example.be_dreamup.dto.RoleDTO;
import org.example.be_dreamup.dto.RoleResponseDTO;

import java.util.List;

public interface RoleService {
    RoleResponseDTO create(RoleDTO dto);
    RoleResponseDTO update(Long id, RoleDTO dto);
    void delete(Long id);
    List<RoleResponseDTO> getAll();
    RoleResponseDTO getById(Long id);
}
