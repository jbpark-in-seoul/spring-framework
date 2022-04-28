package tutorial.core.springframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tutorial.core.springframework.Order.OrderService;
import tutorial.core.springframework.Order.OrderServiceImpl;
import tutorial.core.springframework.discount.DiscountPolicy;
import tutorial.core.springframework.discount.RateDiscountPolicy;
import tutorial.core.springframework.member.MemberService;
import tutorial.core.springframework.member.MemberServiceImpl;
import tutorial.core.springframework.member.MemoryMemberRepository;

// #책임:구현 객체 생성 및 연결
@Configuration
public class AppConfig {
    // #생성자 주입: 의존 관계 주입(DI)
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
