package org.example.be_dreamup.dto;

import lombok.Data;

import java.util.Set;

@Data
public class RoleResponseDTO {
    private Long id;

    private String name;

    private String note;

    private Set<Long> permissionIds;

    private Set<String> permissionNames;
}
