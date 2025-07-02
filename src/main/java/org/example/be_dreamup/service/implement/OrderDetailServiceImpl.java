package org.example.be_dreamup.service.implement;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.dto.OrderDetailDTO;
import org.example.be_dreamup.dto.OrderDetailResponseDTO;
import org.example.be_dreamup.mapper.OrderDetailMapper;
import org.example.be_dreamup.model.Order;
import org.example.be_dreamup.model.OrderDetail;
import org.example.be_dreamup.model.Product;
import org.example.be_dreamup.repository.OrderDetailRepository;
import org.example.be_dreamup.repository.OrderRepository;
import org.example.be_dreamup.repository.ProductRepository;
import org.example.be_dreamup.service.OrderDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository repository;
    private final OrderDetailMapper mapper;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public Product getProduct(String productId) {
        Product product = productRepository.findBySKU(productId);
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sản phẩm không tồn tại!");
        }
        return product;
    }

    public Order getOrder(String orderId) {
        Order order = orderRepository.findByOrderId(orderId);
        if (order == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Đơn hàng không tồn tại!");
        }
        return order;
    }

    @Override
    @Transactional
    public OrderDetailResponseDTO create (OrderDetailDTO dto) {
        Product product = getProduct(dto.getProductId());
        Order order = getOrder(dto.getOrderId());
        OrderDetail entity = mapper.toEntity(dto, order, product);
        OrderDetail saved = repository.save(entity);
        return mapper.toResponseDTO(saved);
    }

    @Override
    @Transactional
    public OrderDetailResponseDTO update(Long id, OrderDetailDTO dto) {
        Product product = getProduct(dto.getProductId());
        Order order = getOrder(dto.getOrderId());
        OrderDetail entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Chi tiết đơn hàng không tồn tại!"));
        mapper.updateEntityFromDTO(dto, entity, order, product);
        OrderDetail updated = repository.save(entity);
        return mapper.toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        OrderDetail entity = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Chi tiết đơn hàng không tồn tại!"));
        entity.setDeleted(true);
        repository.save(entity);
    }

    @Override
    public List<OrderDetailResponseDTO> getAll() {
        return repository.findByIsDeletedFalse().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public OrderDetailResponseDTO getById(Long id) {
        OrderDetail entity = repository.findById(id).filter(od -> !od.isDeleted()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Chi tiết đơn hàng không tồn tại!"));
        return mapper.toResponseDTO(entity);
    }
}
