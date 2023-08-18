package com.min.shop;

import com.min.shop.domain.Address;
import com.min.shop.domain.Member;
import com.min.shop.domain.item.Book;
import com.min.shop.service.BookService;
import com.min.shop.service.MemberService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestInit {

    private final MemberService memberService;
    private final BookService bookService;

    @PostConstruct
    public void init() {
        Member member = new Member();
        member.setLoginId("t");
        member.setName("테스트계정");
        member.setPassword("t");
        member.setAddress(new Address("시티", "거리", "집코드"));

        memberService.join(member);

        Book book = new Book();
        book.setName("리팩터링");
        book.setStockQuantity(10);
        book.setPrice(30000);
        book.setIsbn("1541");
        book.setAuthor("마틴 파울러");
        book.setDescription("지난 20년간 전 세계 프로그래머에게 리팩터링의 교본이었던 리팩토링은, 기존 코드의 디자인을 개선하고 소프트웨어 유지 관리 능력을 향상시켰으며 기존 코드를 이해하기 쉽게 만드는 데 도움을 주었다. 간절히 기다려온 개정판 『리팩터링 2판』에는 프로그래밍 환경의 중요한 변화가 대거 반영되었다. 새로운 리팩터링 카탈로그를 자바스크립트 코드로 제시하며, 리팩터링 원칙부터 클래스 없이 리팩터링하는 방법과 데이터 조직화, 조건부 로직 간소화 방법을 다룬다. 또한 언어에 상관없이 리팩터링을 성공적으로 수행하는 실질적인 방법을 알려준다.");

        bookService.saveItem(book);
    }
}
