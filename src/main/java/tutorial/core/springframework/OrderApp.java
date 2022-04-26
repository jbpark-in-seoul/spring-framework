package tutorial.core.springframework;

import tutorial.core.springframework.Order.Order;
import tutorial.core.springframework.Order.OrderService;
import tutorial.core.springframework.member.Grade;
import tutorial.core.springframework.member.Member;
import tutorial.core.springframework.member.MemberService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();


        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        // # DIP 위반
        //MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
        //OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
