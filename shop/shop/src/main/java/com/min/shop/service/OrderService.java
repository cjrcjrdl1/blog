package com.min.shop.service;

import com.min.shop.entity.*;
import com.min.shop.entity.item.Book;
import com.min.shop.entity.item.BookRepository;
import com.min.shop.entity.member.Member;
import com.min.shop.entity.member.MemberRepository;
import com.min.shop.entity.order.Order;
import com.min.shop.entity.order.OrderItem;
import com.min.shop.entity.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    //주문
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        
        //엔티티 조회
        Member member = memberRepository.findById(memberId).get();
        Book book = bookRepository.findById(itemId).get();

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);
        
        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(book, book.getPrice(), count);

        //주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);
        
        //주문 저장
        orderRepository.save(order);
        return order.getId();
    }

    //주문 취소
    @Transactional
    public void cancelOrder(Long orderId) {
        //주문 엔티티 조회
        Order order = orderRepository.findById(orderId).get();
        //주문 취소
        order.cancel();
    }

    //주문 검색
//    public List<Order> findOrders(OrderSearch orderSearch) {
//        return orderRepository.findAllByString(orderSearch);
//    }
}
