package org.example.be_dreamup.service.implement;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.dto.ProductDTO;
import org.example.be_dreamup.dto.ProductResponseDTO;
import org.example.be_dreamup.mapper.ProductMapper;
import org.example.be_dreamup.model.Product;
import org.example.be_dreamup.model.ProductCategory;
import org.example.be_dreamup.model.UnitPackage;
import org.example.be_dreamup.model.UnitWeight;
import org.example.be_dreamup.repository.ProductCategoryRepository;
import org.example.be_dreamup.repository.ProductRepository;
import org.example.be_dreamup.repository.UnitPackageRepository;
import org.example.be_dreamup.repository.UnitWeightRepository;
import org.example.be_dreamup.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final ProductCategoryRepository productCategoryRepository;
    private final UnitWeightRepository unitWeightRepository;
    private final UnitPackageRepository unitPackageRepository;

    @Override
    @Transactional
    public ProductResponseDTO create (ProductDTO dto) {
        ProductCategory category = productCategoryRepository.findByProductCategoryId(dto.getProductCategoryId());
        UnitWeight unitWeight = unitWeightRepository.findById(dto.getUnitWeightId()).orElse(null);
        UnitPackage unitPackage = unitPackageRepository.findById(dto.getUnitPackageId()).orElse(null);
        Product entity = mapper.toEntity(dto, category, unitWeight, unitPackage);
        Product saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public ProductResponseDTO update (String SKU, ProductDTO dto) {
        ProductCategory category = productCategoryRepository.findByProductCategoryId(dto.getProductCategoryId());
        UnitWeight unitWeight = unitWeightRepository.findById(dto.getUnitWeightId()).orElse(null);
        UnitPackage unitPackage = unitPackageRepository.findById(dto.getUnitPackageId()).orElse(null);
        Product entity = repository.findBySKU(SKU);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sản phẩm không tồn tại!");
        }
        mapper.updateEntityFromDTO(dto, entity, category, unitWeight, unitPackage);
        Product updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void delete(String SKU) {
        Product entity = repository.findBySKU(SKU);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sản phẩm không tồn tại!");
        }
        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public List<ProductResponseDTO> getAll() {
        return repository.findByIsDeletedFalse().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO getById (String SKU) {
        Product entity = repository.findBySKU(SKU);
        if (entity == null || !entity.isDeleted()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sản phẩm không tồn tại!");
        }
        return mapper.toResponseDTO(entity);
    }
}

