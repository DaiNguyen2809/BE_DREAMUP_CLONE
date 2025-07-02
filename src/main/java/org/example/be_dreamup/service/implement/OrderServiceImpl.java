package org.example.be_dreamup.service.implement;

import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.config.OrderStatus;
import org.example.be_dreamup.dto.OrderDTO;
import org.example.be_dreamup.dto.OrderDetailDTO;
import org.example.be_dreamup.dto.OrderResponseDTO;
import org.example.be_dreamup.mapper.OrderDetailMapper;
import org.example.be_dreamup.mapper.OrderMapper;
import org.example.be_dreamup.model.*;
import org.example.be_dreamup.repository.*;
import org.example.be_dreamup.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;
    private final ProductRepository productRepository;
    private final OrderDetailMapper orderDetailMapper;

    public Customer getCustomer(OrderDTO dto) {
        Customer customer = customerRepository.findByCustomerId(dto.getCustomerId());
        if (customer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Khách hàng không tồn tại!");
        }
        return customer;
    }

    public User getStaff(OrderDTO dto) {
        User staff = userRepository.findByUsername(dto.getStaffId());
        if (staff == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nhân viên không tồn tại!");
        }
        return staff;
    }

    public Payment getPayment(OrderDTO dto) {
        return paymentRepository.findById(dto.getPaymentCategoryId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Phương thức thanh toán không tồn tại!"));
    }

    public Product getProduct(OrderDetailDTO dto) {
        Product product = productRepository.findBySKU(dto.getProductId());
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sản phẩm không tồn tại!");
        }
        return product;
    }

    public Order getOrder(String orderId) {
        Order order = repository.findByOrderId(orderId);
        if (order == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Đơn hàng không tồn tại!");
        }
        return order;
    }

    @Override
    public OrderResponseDTO create(OrderDTO dto) {
        Customer customer = getCustomer(dto);
        User staff = getStaff(dto);
        Payment paymentCategory = getPayment(dto);

        Set<OrderDetail> orderDetails = dto.getOrderDetails().stream()
                .map(detailDTO -> {
                   Product product = getProduct(detailDTO);
                   // order gán sau
                   return orderDetailMapper.toEntity(detailDTO, null, product);
                }).collect(Collectors.toSet());

        Order entity = mapper.toEntity(dto, customer, staff, paymentCategory, orderDetails);
        // gán order cho từng orderDetail có trong bản ghi
        orderDetails.forEach(orderDetail -> orderDetail.setOrder(entity));
        Order saved = repository.save(entity);
        return mapper.toResponseDTO(saved, saved.getOrderDetails());
    }

    @Override
    public OrderResponseDTO update(String orderId, OrderDTO dto) {
        Order existingOrder = getOrder(orderId);
        Customer customer = getCustomer(dto);
        User user = getStaff(dto);
        Payment paymentCategory = getPayment(dto);

        Set<OrderDetail> updatedDetails = dto.getOrderDetails().stream()
                .map(detailDTO -> {
                    Product product = getProduct(detailDTO);
                    // kiểm tra nếu đã có thì update, chưa thì tạo mới
                    return existingOrder.getOrderDetails().stream()
                            .filter(orderDetail -> orderDetail.getProduct().getSKU().equals(detailDTO.getProductId()))
                            .findFirst()
                            .map(existingDetail -> {
                                orderDetailMapper.updateEntityFromDTO(detailDTO, existingDetail, existingOrder, product);
                                return existingDetail;
                            }).orElseGet(() -> orderDetailMapper.toEntity(detailDTO, existingOrder, product));
                }).collect(Collectors.toSet());

        mapper.updateEntityFromDTO(dto, existingOrder, customer, user, paymentCategory, updatedDetails);
        // xóa orderDetail không còn trong OrderDTO
        Set<String> updatedSKU = dto.getOrderDetails().stream()
                .map(OrderDetailDTO::getProductId).collect(Collectors.toSet());
        existingOrder.getOrderDetails().removeIf(detail -> updatedSKU.contains(detail.getProduct().getSKU()));
        Order updated = repository.save(existingOrder);
        return mapper.toResponseDTO(updated, updated.getOrderDetails());
    }

    @Override
    public List<OrderResponseDTO> getAll() {
        return repository.findByIsDeletedFalse().stream().map(order -> mapper.toResponseDTO(order, order.getOrderDetails())).collect(Collectors.toList());
    }

    @Override
    public OrderResponseDTO getById(String orderId) {
        Order entity = repository.findByOrderId(orderId);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Đơn hàng không tồn tại!");
        }
        return mapper.toResponseDTO(entity, entity.getOrderDetails());
    }

    @Override
    public void changeOrderStatusProcessing(String orderId) {
        Order entity = getOrder(orderId);
        entity.setOrderStatus(OrderStatus.PROCESSING);
    }

    @Override
    public void changeOrderStatusPackaging(String orderId) {
        Order entity = getOrder(orderId);
        entity.setOrderStatus(OrderStatus.PACKAGING);
    }

    @Override
    public void changeOrderStatusDelivery(String orderId) {
        Order entity = getOrder(orderId);
        entity.setOrderStatus(OrderStatus.DELIVERY);
    }

    @Override
    public void changeOrderStatusCompleted(String orderId) {
        Order entity = getOrder(orderId);
        entity.setOrderStatus(OrderStatus.COMPLETED);
    }

    @Override
    public void changeOrderStatusCancelled(String orderId) {
        Order entity = getOrder(orderId);
        entity.setOrderStatus(OrderStatus.CANCELLED);
    }
}
