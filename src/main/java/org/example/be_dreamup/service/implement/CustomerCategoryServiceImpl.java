package org.example.be_dreamup.service.implement;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.dto.CustomerCategoryDTO;
import org.example.be_dreamup.dto.CustomerCategoryResponseDTO;
import org.example.be_dreamup.mapper.CustomerCategoryMapper;
import org.example.be_dreamup.model.CustomerCategory;
import org.example.be_dreamup.repository.CustomerCategoryRepository;
import org.example.be_dreamup.service.CustomerCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerCategoryServiceImpl implements CustomerCategoryService {
    private final CustomerCategoryRepository repository;
    private final CustomerCategoryMapper mapper;

    @Override
    @Transactional
    public CustomerCategoryResponseDTO create(CustomerCategoryDTO dto) {
        CustomerCategory entity = mapper.toEntity(dto);
        CustomerCategory saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public CustomerCategoryResponseDTO update(Long id, CustomerCategoryDTO dto) {
        CustomerCategory entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mã nhóm khách hàng không tồn tại"));
        mapper.updateEntityFromDTO(dto, entity);
        CustomerCategory updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        CustomerCategory entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mã nhóm khách hàng không tồn tại"));
        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public List<CustomerCategoryResponseDTO> getAll() {
        return repository.findByIsDeletedFalse().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public CustomerCategoryResponseDTO getById(Long id) {
        CustomerCategory entity = repository.findById(id).filter(cat -> !cat.isDeleted()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nhóm khách hàng không tồn tại"));
        return mapper.toResponseDTO(entity);
    }


}
