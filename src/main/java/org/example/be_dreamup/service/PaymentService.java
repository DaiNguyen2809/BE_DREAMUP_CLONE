package org.example.be_dreamup.service;

import org.example.be_dreamup.dto.PaymentDTO;
import org.example.be_dreamup.dto.PaymentResponseDTO;
import org.example.be_dreamup.model.Payment;

import java.util.List;

public interface PaymentService {
    PaymentResponseDTO create(PaymentDTO dto);
    PaymentResponseDTO update(Long id, PaymentDTO dto);
    void delete(Long id);
    List<PaymentResponseDTO> getAll();
    PaymentResponseDTO getById(Long id);
}
