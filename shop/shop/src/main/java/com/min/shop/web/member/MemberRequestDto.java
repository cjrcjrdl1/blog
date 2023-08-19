package com.min.shop.web.member;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MemberRequestDto {

    @NotBlank
    private String loginId;

    @NotBlank
    private String name;

    @NotBlank
    private String password;
    private String city;
    private String street;
    private String zipcode;

}
