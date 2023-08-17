package com.min.shop.web;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {

    @NotBlank
    private String loginId;

    @NotBlank
    private String password;
}
