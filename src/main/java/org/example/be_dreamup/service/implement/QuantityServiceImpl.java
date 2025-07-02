package org.example.be_dreamup.service.implement;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.dto.QuantityDTO;
import org.example.be_dreamup.dto.QuantityResponseDTO;
import org.example.be_dreamup.mapper.QuantityMapper;
import org.example.be_dreamup.model.Product;
import org.example.be_dreamup.model.Quantity;
import org.example.be_dreamup.repository.QuantityRepository;
import org.example.be_dreamup.service.QuantityService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuantityServiceImpl implements QuantityService {
    private final QuantityRepository repository;
    private final QuantityMapper mapper;

    @Override
    @Transactional
    public QuantityResponseDTO create(QuantityDTO dto, Product product) {
        Quantity entity = mapper.toEntity(dto, product);
        Quantity saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public QuantityResponseDTO update(Long id, QuantityDTO dto, Product product) {
        Quantity entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy số lượng sản phẩm tương ứng!"));
        mapper.updateEntityFromDTO(dto, entity, product);
        Quantity updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Quantity entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy số lượng sản phẩm tương ứng!"));
        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public List<QuantityResponseDTO> getAll() {
        return repository.findByIsDeletedFalse().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public QuantityResponseDTO getById(Long id) {
        Quantity entity = repository.findById(id).filter(q -> !q.isDeleted()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy số lượng sản phẩm tương ứng!"));
        return mapper.toResponseDTO(entity);
    }
}
