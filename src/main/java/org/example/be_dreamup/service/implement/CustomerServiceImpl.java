package org.example.be_dreamup.service.implement;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.dto.CustomerDTO;
import org.example.be_dreamup.dto.CustomerResponseDTO;
import org.example.be_dreamup.mapper.CustomerMapper;
import org.example.be_dreamup.model.Customer;
import org.example.be_dreamup.model.CustomerCategory;
import org.example.be_dreamup.model.User;
import org.example.be_dreamup.repository.CustomerRepository;
import org.example.be_dreamup.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    @Transactional
    public CustomerResponseDTO create(CustomerDTO dto, CustomerCategory category, User user) {
        Customer entity = mapper.toEntity(dto, category, user);
        Customer saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public CustomerResponseDTO update(Long id, CustomerDTO dto, CustomerCategory category, User user) {
        Customer entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Khách hàng không tồn tại!"));
        mapper.updateEntityFromDTO(dto, entity, category, user);
        Customer updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Customer entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Khách hàng không tồn tại!"));
        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public List<CustomerResponseDTO> getAll() {
        return repository.findByIsDeletedFalse().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDTO getById(Long id) {
        Customer entity = repository.findById(id).filter(cus -> !cus.isDeleted()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Khách hàng không tồn tại!"));
        return mapper.toResponseDTO(entity);
    }
}
