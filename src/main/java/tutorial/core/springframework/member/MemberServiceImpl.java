package tutorial.core.springframework.member;

public class MemberServiceImpl implements MemberService {
    // #DIP 성립 : 인터페이스에만 의존
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // #OCP, DIP 위반되는 코드
    // private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
