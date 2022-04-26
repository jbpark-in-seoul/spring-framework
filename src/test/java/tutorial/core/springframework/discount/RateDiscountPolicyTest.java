package tutorial.core.springframework.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tutorial.core.springframework.member.Grade;
import tutorial.core.springframework.member.Member;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        //given
        Member memberVIP = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(memberVIP, 10000);
        //then
        assertThat(discount).isEqualTo(1000);

    }


    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        //given
        Member memberBASIC = new Member(1L, "memberVIP", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(memberBASIC, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

}