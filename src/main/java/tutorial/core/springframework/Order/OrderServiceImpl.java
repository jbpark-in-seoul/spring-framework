package tutorial.core.springframework.Order;

import tutorial.core.springframework.discount.DiscountPolicy;
import tutorial.core.springframework.member.Member;
import tutorial.core.springframework.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    // #DIP 성립 : 인터페이스에만 의존
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    // #OCP, DIP 위반되는 코드
    //private DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //private DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // #SRP 잘 지켜진 예

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
