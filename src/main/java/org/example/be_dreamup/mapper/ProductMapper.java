package org.example.be_dreamup.mapper;

import org.example.be_dreamup.dto.ProductDTO;
import org.example.be_dreamup.dto.ProductResponseDTO;
import org.example.be_dreamup.model.Product;
import org.example.be_dreamup.model.ProductCategory;
import org.example.be_dreamup.model.UnitPackage;
import org.example.be_dreamup.model.UnitWeight;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public void mapper(ProductDTO dto, Product entity, ProductCategory category, UnitWeight unitWeight, UnitPackage unitPackage) {
        entity.setSKU(dto.getSKU());
        entity.setName(dto.getName());
        entity.setCategory(category);
        entity.setDescription(dto.getDescription());
        entity.setGrinds(dto.getGrinds());
        entity.setBarcode(dto.getBarcode());
        entity.setWeight(dto.getWeight());
        entity.setUnitWeight(unitWeight);
        entity.setUnitPackage(unitPackage);
        entity.setRoastLevels(dto.getRoastLevels());
        entity.setTags(dto.getTags());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setImage(dto.getImage());
        entity.setImage2(dto.getImage2());
        entity.setImage3(dto.getImage3());
        entity.setImage4(dto.getImage4());
    }

    public Product toEntity(ProductDTO dto, ProductCategory category, UnitWeight unitWeight, UnitPackage unitPackage) {
        Product entity = new Product();
        mapper(dto, entity, category, unitWeight, unitPackage);
        return entity;
    }

    public void updateEntityFromDTO(ProductDTO dto, Product entity, ProductCategory category, UnitWeight unitWeight, UnitPackage unitPackage) {
        mapper(dto, entity, category, unitWeight, unitPackage);
    }

    public ProductResponseDTO toResponseDTO(Product entity) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(entity.getId());
        dto.setSKU(entity.getSKU());
        dto.setName(entity.getName());
        dto.setProductCategoryId(entity.getCategory().getProductCategoryId());
        dto.setDescription(entity.getDescription());
        dto.setGrinds(entity.getGrinds());
        dto.setBarcode(entity.getBarcode());
        dto.setWeight(entity.getWeight());
        dto.setUnitWeightId(entity.getUnitWeight().getId());
        dto.setUnitWeightName(entity.getUnitWeight().getName());
        dto.setUnitPackageId(entity.getUnitPackage().getId());
        dto.setUnitPackageName(entity.getUnitPackage().getName());
        dto.setRoastLevels(entity.getRoastLevels());
        dto.setTags(entity.getTags());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setImage(entity.getImage());
        dto.setImage2(entity.getImage2());
        dto.setImage3(entity.getImage3());
        dto.setImage4(entity.getImage4());
        return dto;
    }
}
