package org.example.be_dreamup.service;

import org.example.be_dreamup.dto.OrderDTO;
import org.example.be_dreamup.dto.OrderResponseDTO;

import java.util.List;

public interface OrderService {
    OrderResponseDTO create(OrderDTO dto);
    OrderResponseDTO update(String orderId, OrderDTO dto);
    List<OrderResponseDTO> getAll();
    OrderResponseDTO getById(String orderId);
    void changeOrderStatusProcessing(String orderId);
    void changeOrderStatusPackaging(String orderId);
    void changeOrderStatusDelivery(String orderId);
    void changeOrderStatusCompleted(String orderId);
    void changeOrderStatusCancelled(String orderId);
}
