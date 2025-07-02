package org.example.be_dreamup.service;


import org.example.be_dreamup.dto.CustomerDTO;
import org.example.be_dreamup.dto.CustomerResponseDTO;
import org.example.be_dreamup.model.CustomerCategory;
import org.example.be_dreamup.model.User;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO create(CustomerDTO dto, CustomerCategory category, User user);
    CustomerResponseDTO update(Long id, CustomerDTO dto, CustomerCategory category, User user);
    void delete(Long id);
    List<CustomerResponseDTO> getAll();
    CustomerResponseDTO getById(Long id);
}
