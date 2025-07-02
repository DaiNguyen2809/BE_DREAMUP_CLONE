package org.example.be_dreamup.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UnitWeightDTO {
    @NotBlank(message = "Tên đơn vị tính không được để trống!")
    @Size(max = 100, message = "Tên đơn vị tính tối đa 100 ký tự!")
    private String name;
}
