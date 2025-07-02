package org.example.be_dreamup.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.dto.ProductCategoryDTO;
import org.example.be_dreamup.dto.ProductCategoryResponseDTO;
import org.example.be_dreamup.service.ProductCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product_category")
@RequiredArgsConstructor
public class ProductCategoryController {
    private final ProductCategoryService service;

    @PostMapping
    public ResponseEntity<ProductCategoryResponseDTO> create(@RequestBody @Valid ProductCategoryDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCategoryResponseDTO> update(@PathVariable Long id, @RequestBody @Valid ProductCategoryDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductCategoryResponseDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductCategoryResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
