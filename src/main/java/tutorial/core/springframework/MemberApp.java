package tutorial.core.springframework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tutorial.core.springframework.member.Grade;
import tutorial.core.springframework.member.Member;
import tutorial.core.springframework.member.MemberService;

/**
 * #기본 테스트 main class -> jUnit
 * #설계 도메인
 *  1.회원은 상품을 주문할 수 있다.
 *  2.회원 등급에 따라 할인 정책을 적용할 수 있다.
 *  3.할인 정책은 모든 Vip는 고정 1000원 할인
 *  4.할인 정책은 변경될 수 있다.
  */

public class MemberApp {

    public static void main(String[] args) {

        // #JAVA 주입
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl();

        // #DI컨테이너 (=IoC 컨테이너)
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMEmber = memberService.findMember(1L);
        System.out.println("new Member = " + memberA.getName());
        System.out.println("find Member = " + findMEmber.getName());

    }
}
