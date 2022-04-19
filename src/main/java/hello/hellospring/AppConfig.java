package hello.hellospring;

import hello.hellospring.domain.discount.DiscountPolicy;
import hello.hellospring.domain.discount.FixDiscountPolicy;
import hello.hellospring.domain.discount.RateDiscountPolicy;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import hello.hellospring.service.MemberServiceImpl;
import hello.hellospring.service.OrderService;
import hello.hellospring.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}

