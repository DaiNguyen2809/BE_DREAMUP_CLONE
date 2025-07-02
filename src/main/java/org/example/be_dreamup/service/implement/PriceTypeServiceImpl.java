package org.example.be_dreamup.service.implement;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.dto.PriceTypeDTO;
import org.example.be_dreamup.dto.PriceTypeResponseDTO;
import org.example.be_dreamup.mapper.PriceTypeMapper;
import org.example.be_dreamup.model.PriceType;
import org.example.be_dreamup.repository.PriceTypeRepository;
import org.example.be_dreamup.service.PriceTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PriceTypeServiceImpl implements PriceTypeService {
    private final PriceTypeRepository repository;
    private final PriceTypeMapper mapper;

    @Override
    @Transactional
    public PriceTypeResponseDTO create (PriceTypeDTO dto) {
        PriceType entity = mapper.toEntity(dto);
        PriceType saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public PriceTypeResponseDTO update(String typeId, PriceTypeDTO dto) {
        PriceType entity = repository.findByTypeId(typeId);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Chính sách giá không tồn tại");
        }
        mapper.updateEntityFromDTO(dto, entity);
        PriceType updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void delete(String typeId) {
        PriceType entity = repository.findByTypeId(typeId);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Chính sách giá không tồn tại");
        }
        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public List<PriceTypeResponseDTO> getAll() {
        return repository.findByIsDeletedFalse().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public PriceTypeResponseDTO getByTypeId(String typeId) {
        PriceType entity = repository.findByTypeId(typeId);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Chính sách giá không tồn tại");
        }
        return mapper.toResponseDTO(entity);
    }
}
