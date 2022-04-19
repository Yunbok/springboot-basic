package hello.hellospring.service;

import hello.hellospring.AppConfig;
import hello.hellospring.domain.Grade;
import hello.hellospring.domain.Member;

import hello.hellospring.domain.order.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class OrderServiceTest {


    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    public void createOrder() {

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
