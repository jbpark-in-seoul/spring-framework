package tutorial.core.springframework.order;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tutorial.core.springframework.AppConfig;
import tutorial.core.springframework.Order.Order;
import tutorial.core.springframework.Order.OrderService;
import tutorial.core.springframework.member.Grade;
import tutorial.core.springframework.member.Member;
import tutorial.core.springframework.member.MemberService;

public class OrderServiceTest {


    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    //MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
    //OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());

    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
