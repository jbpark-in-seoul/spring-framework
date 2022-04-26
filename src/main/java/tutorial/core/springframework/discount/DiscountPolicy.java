package tutorial.core.springframework.discount;

import tutorial.core.springframework.member.Member;

public interface DiscountPolicy {


    /**
     * 할인 대상 금액
     * @param member
     * @param price
     * @return
     */
    int discount(Member member, int price);
}
