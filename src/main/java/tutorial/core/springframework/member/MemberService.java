package tutorial.core.springframework.member;

// #회원가입, 회원 조회
public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
