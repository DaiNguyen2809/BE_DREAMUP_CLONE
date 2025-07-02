package org.example.be_dreamup.dto;

import lombok.Data;
import org.example.be_dreamup.config.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CustomerResponseDTO {
    private Long id;

    private String customerId;

    private String name;

    private String customerCategoryName;

    private String phone;

    private LocalDate birthday;

    private Gender gender;

    private List<AddressResponseDTO> addresses;

    private String description;

    private String tag;

    private Long debt;

    private Long totalExpenditures;

    private Long totalOrders;

    private Long totalProducts;

    private Long totalReturnProducts;

    private Long point;

    private String affiliate;

    private String specialCode;

    private LocalDateTime createdAt;

    private Long userId;
}
