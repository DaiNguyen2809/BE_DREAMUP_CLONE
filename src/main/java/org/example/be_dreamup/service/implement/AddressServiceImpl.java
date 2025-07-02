package org.example.be_dreamup.service.implement;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.dto.AddressDTO;
import org.example.be_dreamup.dto.AddressResponseDTO;
import org.example.be_dreamup.mapper.AddressMapper;
import org.example.be_dreamup.model.Address;
import org.example.be_dreamup.repository.AddressRepository;
import org.example.be_dreamup.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;
    private final AddressMapper mapper;

    @Override
    @Transactional
    public AddressResponseDTO create (AddressDTO dto) {
        Address entity = mapper.toEntity(dto);
        Address saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public AddressResponseDTO update (Long id, AddressDTO dto) {
        Address entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Địa chỉ không tồn tại!"));
        mapper.updateEntityFromDTO(dto, entity);
        Address updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void delete (Long id) {
        Address entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Địa chỉ không tồn tại!"));
        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public List<AddressResponseDTO> getAll() {
        return repository.findByIsDeletedFalse().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public AddressResponseDTO getById(Long id) {
        Address entity = repository.findById(id).filter(add -> !add.isDeleted()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Địa chỉ không tồn tại!"));
        return mapper.toResponseDTO(entity);
    }

    @Override
    @Transactional
    public void changeAddressStatusToUnDefault(Long id) {
        Address entity = repository.findById(id).filter(add -> !add.isDeleted()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Địa chỉ không tồn tại!"));
        entity.setDefault(false);
    }

    @Override
    @Transactional
    public void changeAddressStatusToDefault(Long id) {
        Address entity = repository.findById(id).filter(add -> !add.isDeleted()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Địa chỉ không tồn tại!"));
        entity.setDefault(true);
    }
}
