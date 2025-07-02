package org.example.be_dreamup.service.implement;

import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.config.FulfillmentStatus;
import org.example.be_dreamup.dto.FulfillmentDTO;
import org.example.be_dreamup.dto.FulfillmentResponseDTO;
import org.example.be_dreamup.mapper.FulfillmentMapper;
import org.example.be_dreamup.model.Fulfillment;
import org.example.be_dreamup.model.Order;
import org.example.be_dreamup.repository.FulfillmentRepository;
import org.example.be_dreamup.repository.OrderRepository;
import org.example.be_dreamup.service.FulfillmentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FulfillmentServiceImpl implements FulfillmentService {
    private final FulfillmentRepository repository;
    private final FulfillmentMapper mapper;
    private final OrderRepository orderRepository;

    public Order getOrder(String orderId) {
        Order order = orderRepository.findByOrderId(orderId);
        if(order == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Đơn hàng không tồn tại!");
        }
        return order;
    }

    public Fulfillment getFulfillment(Long fulfillmentId) {
        Fulfillment entity = repository.findById(fulfillmentId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hóa đơn đóng gói không tồn tại"));
        return entity;
    }

    @Override
    public FulfillmentResponseDTO create(FulfillmentDTO dto) {
        Order order = getOrder(dto.getOrderId());
        Fulfillment entity = mapper.toEntity(dto, order);
        Fulfillment saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    public FulfillmentResponseDTO update(Long id, FulfillmentDTO dto) {
        Fulfillment entity = getFulfillment(id);
        Order order = getOrder(dto.getOrderId());
        mapper.updateEntityFromDTO(dto, entity, order);
        Fulfillment updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    public List<FulfillmentResponseDTO> getAll() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public FulfillmentResponseDTO getById(Long id) {
        Fulfillment entity = getFulfillment(id);
        return mapper.toResponseDTO(entity);
    }

    @Override
    public void changeFulfillmentStatusConfirm(Long id) {
        Fulfillment entity = getFulfillment(id);
        entity.setFulfillmentStatus(FulfillmentStatus.CONFIRMED);
        repository.save(entity);
    }

    @Override
    public void changeFulfillmentStatusReject(Long id) {
        Fulfillment entity = getFulfillment(id);
        entity.setFulfillmentStatus(FulfillmentStatus.REJECTED);
        repository.save(entity);
    }
}
