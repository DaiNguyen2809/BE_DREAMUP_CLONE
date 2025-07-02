package org.example.be_dreamup.service.implement;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.dto.PaymentDTO;
import org.example.be_dreamup.dto.PaymentResponseDTO;
import org.example.be_dreamup.mapper.PaymentMapper;
import org.example.be_dreamup.model.Payment;
import org.example.be_dreamup.repository.PaymentRepository;
import org.example.be_dreamup.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository repository;
    private final PaymentMapper mapper;

    @Override
    @Transactional
    public PaymentResponseDTO create (PaymentDTO dto) {
        Payment entity = mapper.toEntity(dto);
        Payment saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public PaymentResponseDTO update (Long id, PaymentDTO dto) {
        Payment entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Phương thức thanh toán không tồn tại!"));
        mapper.updateEntityFromDTO(dto, entity);
        Payment updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void delete (Long id) {
        Payment entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Phương thức thanh toán không tồn tại!"));
        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public List<PaymentResponseDTO> getAll() {
        return repository.findByIsDeletedFalse().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public PaymentResponseDTO getById(Long id) {
        Payment entity = repository.findById(id).filter(p -> !p.isDeleted()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Phương thức thanh toán không tồn tại!"));
        return mapper.toResponseDTO(entity);
    }
}
