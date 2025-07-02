package org.example.be_dreamup.service.implement;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.dto.UnitWeightDTO;
import org.example.be_dreamup.dto.UnitWeightResponseDTO;
import org.example.be_dreamup.mapper.UnitWeightMapper;
import org.example.be_dreamup.model.UnitWeight;
import org.example.be_dreamup.repository.UnitWeightRepository;
import org.example.be_dreamup.service.UnitWeightService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UnitWeightServiceImpl  implements UnitWeightService {
    private final UnitWeightRepository repository;
    private final UnitWeightMapper mapper;

    @Override
    @Transactional
    public UnitWeightResponseDTO create (UnitWeightDTO dto) {
        UnitWeight entity = mapper.toEntity(dto);
        UnitWeight saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public UnitWeightResponseDTO update(Long id, UnitWeightDTO dto) {
        UnitWeight entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Đơn vị tính không tồn tại!"));
        mapper.updateEntityFromDTO(dto, entity);
        UnitWeight updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        UnitWeight entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Đơn vị tính không tồn tại!"));
        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public List<UnitWeightResponseDTO> getAll() {
        return repository.findByIsDeletedFalse().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public UnitWeightResponseDTO getById(Long id) {
        UnitWeight entity = repository.findById(id).filter(uw -> !uw.isDeleted()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Đơn vị tính không tồn tại!"));
        return mapper.toResponseDTO(entity);
    }
}
