package org.example.be_dreamup.service.implement;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.dto.RoleDTO;
import org.example.be_dreamup.dto.RoleResponseDTO;
import org.example.be_dreamup.mapper.RoleMapper;
import org.example.be_dreamup.model.Permission;
import org.example.be_dreamup.model.Role;
import org.example.be_dreamup.repository.PermissionRepository;
import org.example.be_dreamup.repository.RoleRepository;
import org.example.be_dreamup.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    private final PermissionRepository permissionRepository;
    private final RoleMapper mapper;

    @Override
    @Transactional
    public RoleResponseDTO create (RoleDTO dto) {
        Set<Permission> permissions = new HashSet<>(permissionRepository.findAllById(dto.getPermissionIds()));
        Role entity = mapper.toEntity(dto, permissions);
        Role saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public RoleResponseDTO update(Long id, RoleDTO dto) {
        Set<Permission> permissions = new HashSet<>(permissionRepository.findAllById(dto.getPermissionIds()));
        Role entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Quyền không tồn tại!"));
        mapper.updateEntityFromDTO(dto, entity, permissions);
        Role updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Role entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Quyền không tồn tại!"));
        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public List<RoleResponseDTO> getAll() {
        return repository.findByIsDeletedFalse().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public RoleResponseDTO getById(Long id) {
        Role entity = repository.findById(id).filter(r -> !r.isDeleted()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Quyền không tồn tại!"));
        return mapper.toResponseDTO(entity);
    }
}
