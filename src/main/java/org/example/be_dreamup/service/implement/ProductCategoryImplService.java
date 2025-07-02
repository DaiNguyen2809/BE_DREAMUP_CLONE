package org.example.be_dreamup.service.implement;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.dto.ProductCategoryDTO;
import org.example.be_dreamup.dto.ProductCategoryResponseDTO;
import org.example.be_dreamup.mapper.ProductCategoryMapper;
import org.example.be_dreamup.model.ProductCategory;
import org.example.be_dreamup.repository.ProductCategoryRepository;
import org.example.be_dreamup.service.ProductCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductCategoryImplService implements ProductCategoryService {
    private final ProductCategoryRepository repository;
    private final ProductCategoryMapper mapper;

    @Override
    @Transactional
    public ProductCategoryResponseDTO create(ProductCategoryDTO dto) {
        ProductCategory entity = mapper.toEntity(dto);
        ProductCategory saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public ProductCategoryResponseDTO update(Long id, ProductCategoryDTO dto) {
        ProductCategory entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loại sản phẩm không tồn tại"));
        mapper.updateEntityFromDTO(dto, entity);
        ProductCategory updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ProductCategory entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loại sản phẩm không tồn tại"));
        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public List<ProductCategoryResponseDTO> getAll() {
        return repository.findByIsDeletedFalse().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public ProductCategoryResponseDTO getById(Long id) {
        ProductCategory entity = repository.findById(id).filter(cat -> !cat.isDeleted()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loại sản phẩm không tồn tại"));
        return mapper.toResponseDTO(entity);
    }
}
