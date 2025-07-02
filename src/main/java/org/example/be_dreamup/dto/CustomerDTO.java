package org.example.be_dreamup.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.be_dreamup.config.Gender;

import java.time.LocalDate;
import java.util.List;

@Data
public class CustomerDTO {
    @NotBlank(message = "Mã khách hàng không được để trống!")
    @Size(max = 100, message = "Mã khách hàng tối đa 100 ký tự!")
    private String customerId;

    @NotBlank(message = "Tên khách hàng không được để trống!")
    @Size(max = 100, message = "Tên khách hàng tối đa 100 ký tự!")
    private String name;

    @NotBlank(message = "Tên nhóm khách hàng không được để trống!")
    private String customerCategoryName;

    @NotBlank(message = "Số điện thoại không được để trống!")
    @Size(max = 10, message = "Số điện thoại tối đa 10 ký tự!")
    private String phone;

    private LocalDate birthday;

    private Gender gender;

    private List<AddressDTO> addresses;

    private String description;

    @Size(max = 100, message = "Tag tối đa 100 ký tự!")
    private String tag;

    @Min(value = 0L)
    private Long debt;

    @Min(value = 0L)
    @NotBlank(message = "Tổng giá trị các đơn hàng không được rỗng!")
    private Long totalExpenditures;

    @Min(value = 0L)
    @NotBlank(message = "Tổng đơn hàng không được rỗng!")
    private Long totalOrders;

    @Min(value = 0L)
    @NotBlank(message = "Tổng số lượng sản phẩm không được rỗng!")
    private Long totalProducts;

    @Min(value = 0L)
    @NotBlank(message = "Tổng số lượng sản phẩm trả về không được rỗng!")
    private Long totalReturnProducts;

    @Min(value = 0L)
    @NotBlank(message = "Điểm khách hàng không được rỗng!")
    private Long point;

    @Size(max = 500, message = "Mã tiếp thị liên kết tối đa 500 ký tự")
    private String affiliate;

    @Size(max = 500, message = "Mã khách hàng đặc biệt tối đa 500 ký tự")
    private String specialCode;

    @NotBlank(message = "Id tài khoản không được để trống!")
    private Long userId;
}
