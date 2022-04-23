package hello.hellospring.domain.discount;

import hello.hellospring.domain.Grade;
import hello.hellospring.domain.Member;
import org.springframework.stereotype.Component;


public class RateDiscountPolicy implements DiscountPolicy{

    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
