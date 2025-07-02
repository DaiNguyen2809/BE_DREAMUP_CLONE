package org.example.be_dreamup.mapper;

import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.dto.AddressResponseDTO;
import org.example.be_dreamup.dto.CustomerDTO;
import org.example.be_dreamup.dto.CustomerResponseDTO;
import org.example.be_dreamup.model.Address;
import org.example.be_dreamup.model.Customer;
import org.example.be_dreamup.model.CustomerCategory;
import org.example.be_dreamup.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerMapper {
    private final AddressMapper addressMapper;

    public void mapper(Customer entity, CustomerDTO dto, CustomerCategory category, User user) {
        entity.setCustomerId(dto.getCustomerId());
        entity.setName(dto.getName());
        entity.setCustomerCategory(category);
        entity.setPhone(dto.getPhone());
        entity.setBirthday(dto.getBirthday());
        entity.setGender(dto.getGender());
        entity.setDescription(dto.getDescription());
        entity.setTag(dto.getTag());
        entity.setDebt(dto.getDebt());
        entity.setTotalExpenditures(dto.getTotalExpenditures());
        entity.setTotalOrders(dto.getTotalOrders());
        entity.setTotalProducts(dto.getTotalProducts());
        entity.setTotalReturnProducts(dto.getTotalReturnProducts());
        entity.setPoint(dto.getPoint());
        entity.setAffiliate(dto.getAffiliate());
        entity.setSpecialCode(dto.getSpecialCode());
        entity.setUser(user);
    }

    public Customer toEntity(CustomerDTO dto, CustomerCategory category, User user) {
        Customer entity = new Customer();
        mapper(entity, dto, category, user);
        if (dto.getCustomerId() != null) {
            List<Address> addressList = dto.getAddresses().stream().map(addressDTO -> {
                Address address = addressMapper.toEntity(addressDTO);
                address.setCustomer(entity);
                return address;
            }).collect(Collectors.toList());
            entity.setAddresses(addressList);
        }
        return entity;
    }

    public void updateEntityFromDTO(CustomerDTO dto, Customer entity, CustomerCategory category, User user) {
        mapper(entity, dto, category, user);
    }

    public CustomerResponseDTO toResponseDTO(Customer entity) {
        CustomerResponseDTO dto = new CustomerResponseDTO();
        AddressMapper addressMapper = new AddressMapper();
        dto.setCustomerId(entity.getCustomerId());
        dto.setCustomerCategoryName(entity.getCustomerCategory().getName());
        dto.setPhone(entity.getPhone());
        dto.setBirthday(entity.getBirthday());
        dto.setGender(entity.getGender());
        dto.setDescription(entity.getDescription());
        dto.setTag(entity.getTag());
        dto.setDebt(entity.getDebt());
        dto.setTotalExpenditures(entity.getTotalExpenditures());
        dto.setTotalOrders(entity.getTotalOrders());
        dto.setTotalProducts(entity.getTotalProducts());
        dto.setTotalReturnProducts(entity.getTotalReturnProducts());
        dto.setPoint(entity.getPoint());
        dto.setAffiliate(entity.getAffiliate());
        dto.setSpecialCode(entity.getSpecialCode());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUserId(entity.getUser().getId());
        if (entity.getAddresses() != null) {
            List<AddressResponseDTO> addressList = entity.getAddresses().stream().filter(a -> !a.isDeleted()).map(addressMapper::toResponseDTO).collect(Collectors.toList());
            dto.setAddresses(addressList);
        }
        return dto;
    }
}
