package com.min.shop;

import com.min.shop.domain.Address;
import com.min.shop.domain.Member;
import com.min.shop.service.MemberService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestInit {

    private final MemberService memberService;

    @PostConstruct
    public void init() {
        Member member = new Member();
        member.setLoginId("t");
        member.setName("테스트계정");
        member.setPassword("t");
        member.setAddress(new Address("시티", "거리", "집코드"));

        memberService.join(member);
    }
}
