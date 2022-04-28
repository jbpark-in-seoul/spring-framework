package tutorial.core.springframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tutorial.core.springframework.Order.Order;
import tutorial.core.springframework.Order.OrderService;
import tutorial.core.springframework.member.Grade;
import tutorial.core.springframework.member.Member;
import tutorial.core.springframework.member.MemberService;

public class OrderApp {

    public static void main(String[] args) {
        // # DIP 위반
        //MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
        //OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());

        // # JAVA 주입
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //OrderService orderService = appConfig.orderService();

        // # DI 컨테이너 주입 (=IoC 컨테이너)
        //  1.ApplicationContext = 스프링 컨테이너
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);



        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
