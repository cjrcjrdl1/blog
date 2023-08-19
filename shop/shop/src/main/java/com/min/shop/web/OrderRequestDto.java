package com.min.shop.web;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderRequestDto {
    @NotNull
    private Long memberId;
    @NotNull
    private Long itemId;
    @Min(0)
    private int count;

}
