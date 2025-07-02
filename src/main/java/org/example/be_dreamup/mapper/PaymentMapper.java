package org.example.be_dreamup.mapper;

import org.example.be_dreamup.dto.PaymentDTO;
import org.example.be_dreamup.dto.PaymentResponseDTO;
import org.example.be_dreamup.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    public Payment toEntity(PaymentDTO dto) {
        Payment entity = new Payment();
        entity.setName(dto.getName());
        return entity;
    }

    public void updateEntityFromDTO(PaymentDTO dto, Payment entity) {
        entity.setName(dto.getName());
    }

    public PaymentResponseDTO toResponseDTO(Payment entity) {
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }
}
