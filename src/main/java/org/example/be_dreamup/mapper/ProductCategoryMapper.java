package org.example.be_dreamup.mapper;

import org.example.be_dreamup.dto.ProductCategoryDTO;
import org.example.be_dreamup.dto.ProductCategoryResponseDTO;
import org.example.be_dreamup.model.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryMapper {
//    Chuyển dữ liệu từ client sang database,dùng trong CREATE/POST
    public ProductCategory toEntity(ProductCategoryDTO dto) {
        ProductCategory entity = new ProductCategory();
        entity.setProductCategoryId(dto.getProductCategoryId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setQuantity(dto.getQuantity());
        return entity;
    }

//    Cập nhật dữ liệu database thông qua client, dùng trong UPDATE/PUT
    public void updateEntityFromDTO(ProductCategoryDTO dto, ProductCategory entity) {
        entity.setProductCategoryId(dto.getProductCategoryId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setQuantity(dto.getQuantity());
    }

//    Chuyển dữ liệu từ database sang response, dùng trong GET
    public ProductCategoryResponseDTO toResponseDTO(ProductCategory entity) {
        ProductCategoryResponseDTO dto = new ProductCategoryResponseDTO();
        dto.setId(entity.getId());
        dto.setProductCategoryId(entity.getProductCategoryId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setQuantity(entity.getQuantity());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

}
