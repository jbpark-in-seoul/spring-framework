package tutorial.core.springframework;

import tutorial.core.springframework.Order.OrderService;
import tutorial.core.springframework.Order.OrderServiceImpl;
import tutorial.core.springframework.discount.FixDiscountPolicy;
import tutorial.core.springframework.member.MemberService;
import tutorial.core.springframework.member.MemberServiceImpl;
import tutorial.core.springframework.member.MemoryMemberRepository;

public class AppConfig {
    // #생성자 주입: 의존 관계 주입(DI)
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
