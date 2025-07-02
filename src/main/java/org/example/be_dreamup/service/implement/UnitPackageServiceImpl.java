package org.example.be_dreamup.service.implement;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.dto.UnitPackageDTO;
import org.example.be_dreamup.dto.UnitPackageResponseDTO;
import org.example.be_dreamup.mapper.UnitPackageMapper;
import org.example.be_dreamup.model.UnitPackage;
import org.example.be_dreamup.repository.UnitPackageRepository;
import org.example.be_dreamup.service.UnitPackageService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UnitPackageServiceImpl implements UnitPackageService {
    private final UnitPackageRepository repository;
    private final UnitPackageMapper mapper;

    @Override
    @Transactional
    public UnitPackageResponseDTO create (UnitPackageDTO dto) {
        UnitPackage entity = mapper.toEntity(dto);
        UnitPackage saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public UnitPackageResponseDTO update (Long id, UnitPackageDTO dto) {
        UnitPackage entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Đơn vị đóng gói không tồn tại!"));
        mapper.updateEntityFromDTO(dto, entity);
        UnitPackage updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void delete (Long id) {
        UnitPackage entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Đơn vị đóng gói không tồn tại!"));
        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public List<UnitPackageResponseDTO> getAll() {
        return repository.findByIsDeletedFalse().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public UnitPackageResponseDTO getById(Long id) {
        UnitPackage entity = repository.findById(id).filter(up -> !up.isDeleted()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Đơn vị đóng gói không tồn tại!"));
        return mapper.toResponseDTO(entity);
    }
}
