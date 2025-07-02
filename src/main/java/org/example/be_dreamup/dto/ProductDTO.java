package org.example.be_dreamup.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.be_dreamup.config.Grind;
import org.example.be_dreamup.config.RoastLevel;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductDTO {
    @NotBlank(message = "SKU sản phẩm không được để trống!")
    @Size(max = 100, message = "SKU sản phẩm tối đa 100 ký tự!")
    private String SKU;

    @NotBlank(message = "Tên sản phẩm không được để trống!")
    @Size(max = 100, message = "Tên sản phẩm tối đa 100 ký tự!")
    private String name;

    @NotBlank(message = "Mã nhóm sản phẩm không được để trống!")
    private String productCategoryId;

    private String description;

    private List<Grind> grinds;

    @NotBlank(message = "Mã vạch sản phẩm không được để trống!")
    @Size(max = 100, message = "Mã vạch sản phẩm tối đa 100 ký tự!")
    private String barcode;

    @NotNull(message = "Khối lượng không được để trống!")
    @PositiveOrZero(message = "Khối lượng phải >= 0!")
    private Long weight;

    @NotNull(message = "Mã đơn vị khối lượng không được để trống!")
    private Long unitWeightId;

    @NotNull(message = "Mã đơn vị đóng gói không được để trống!")
    private Long unitPackageId;

    private List<RoastLevel> roastLevels;

    @Size(max = 300, message = "Tag sản phẩm tối đa 300 ký tự!")
    private String tags;

    @NotNull(message = "Ngày khởi tạo không được để trống!")
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NotBlank(message = "URL ảnh bìa không được để trống!")
    private String image;

    private String image2;

    private String image3;

    private String image4;
}
