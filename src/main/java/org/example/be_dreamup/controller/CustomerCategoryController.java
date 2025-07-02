package org.example.be_dreamup.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.be_dreamup.dto.CustomerCategoryDTO;
import org.example.be_dreamup.dto.CustomerCategoryResponseDTO;
import org.example.be_dreamup.service.CustomerCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer_category")
@RequiredArgsConstructor
public class CustomerCategoryController {
    private final CustomerCategoryService service;

    @PostMapping
    public ResponseEntity<CustomerCategoryResponseDTO> create(@RequestBody @Valid CustomerCategoryDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerCategoryResponseDTO> update(@PathVariable Long id, @RequestBody @Valid CustomerCategoryDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerCategoryResponseDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerCategoryResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerCategoryResponseDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

}
