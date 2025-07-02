package org.example.be_dreamup.mapper;

import org.example.be_dreamup.dto.*;
import org.example.be_dreamup.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PriceMapper {

    public Price toEntity(PriceDTO dto, List<Product> products, List<PriceType> priceTypes) {
        Price entity = new Price();
        entity.setProducts(products);
        entity.setPriceTypes(priceTypes);
        entity.setPrice(dto.getPrice());
        return entity;
    }

    public void updateEntityFromDTO(Price entity, PriceDTO dto, List<Product> products, List<PriceType> priceTypes) {
        entity.setProducts(products);
        entity.setPriceTypes(priceTypes);
        entity.setPrice(dto.getPrice());
    }

    public PriceResponseDTO toResponseDTO(Price entity) {
        PriceResponseDTO dto = new PriceResponseDTO();
        dto.setId(entity.getId());
        dto.setProductSKUs(
                entity.getProducts().stream()
                        .map(Product::getSKU)
                        .collect(Collectors.toList())
        );
        dto.setProductNames(
                entity.getProducts().stream()
                        .map(Product::getName)
                        .collect(Collectors.toList())
        );
        dto.setPriceTypeIds(
                entity.getPriceTypes().stream()
                        .map(PriceType::getTypeId)
                        .collect(Collectors.toList())
        );
        dto.setPriceTypeNames(
                entity.getPriceTypes().stream()
                        .map(PriceType::getName)
                        .collect(Collectors.toList())
        );
        dto.setPrice(entity.getPrice());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}
