package org.example.be_dreamup.service.implement;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.dto.PriceDTO;
import org.example.be_dreamup.dto.PriceResponseDTO;
import org.example.be_dreamup.mapper.PriceMapper;
import org.example.be_dreamup.model.Price;
import org.example.be_dreamup.model.PriceType;
import org.example.be_dreamup.model.Product;
import org.example.be_dreamup.repository.PriceRepository;
import org.example.be_dreamup.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    private final PriceRepository repository;
    private final PriceMapper mapper;

    @Override
    @Transactional
    public PriceResponseDTO create (PriceDTO dto, List<Product> products, List<PriceType> priceTypes) {
        Price entity = mapper.toEntity(dto, products, priceTypes);
        Price saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public PriceResponseDTO update (Long id, PriceDTO dto, List<Product> products, List<PriceType> priceTypes) {
        Price entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Giá sản phẩm không tồn tại!"));
        mapper.updateEntityFromDTO(entity, dto, products, priceTypes);
        Price updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void delete (Long id) {
        Price entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Giá sản phẩm không tồn tại!"));
        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public List<PriceResponseDTO> getAll() {
        return repository.findByIsDeletedFalse().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public PriceResponseDTO getById(Long id) {
        Price entity = repository.findById(id).filter(p -> !p.isDeleted()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Giá sản phẩm không tồn tại!"));
        return mapper.toResponseDTO(entity);
    }
}
