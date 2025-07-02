package org.example.be_dreamup.service.implement;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.dto.PermissionDTO;
import org.example.be_dreamup.dto.PermissionResponseDTO;
import org.example.be_dreamup.mapper.PermissionMapper;
import org.example.be_dreamup.model.Permission;
import org.example.be_dreamup.repository.PermissionRepository;
import org.example.be_dreamup.service.PermissionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository repository;
    private final PermissionMapper mapper;

    @Override
    @Transactional
    public PermissionResponseDTO create (PermissionDTO dto) {
        Permission entity = mapper.toEntity(dto);
        Permission saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public PermissionResponseDTO update(Long id, PermissionDTO dto) {
        Permission entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Phân quyền không tồn tại!"));
        mapper.updateEntityFromDTO(dto, entity);
        Permission updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Permission entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Phân quyền không tồn tại!"));
        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public List<PermissionResponseDTO> getAll() {
        return repository.findByIsDeletedFalse().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public PermissionResponseDTO getById(Long id) {
        Permission entity = repository.findById(id).filter(p -> !p.isDeleted()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Phân quyền không tồn tại!"));
        return mapper.toResponseDTO(entity);
    }
}
