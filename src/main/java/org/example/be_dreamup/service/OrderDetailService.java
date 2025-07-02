package org.example.be_dreamup.service;

import org.example.be_dreamup.dto.OrderDetailDTO;
import org.example.be_dreamup.dto.OrderDetailResponseDTO;

import java.util.List;

public interface OrderDetailService {
    OrderDetailResponseDTO create(OrderDetailDTO dto);
    OrderDetailResponseDTO update(Long id, OrderDetailDTO dto);
    void delete(Long id);
    List<OrderDetailResponseDTO> getAll();
    OrderDetailResponseDTO getById(Long id);
}
