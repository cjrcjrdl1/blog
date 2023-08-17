package com.min.shop.web;

import com.min.shop.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {
    private String loginId;
    private String name;
    private String password;

    public MemberResponseDto(Member entity) {
        this.loginId = entity.getLoginId();
        this.name = entity.getName();
        this.password = entity.getPassword();
    }

}
