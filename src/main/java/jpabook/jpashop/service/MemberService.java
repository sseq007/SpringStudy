package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.MemberRepositoryOld;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 읽기 경우에 true 아닌 경우에는 @Transactional 달기
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

//    @Autowired  생성자가 하나일 경우 생략 가능
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    /**
     * 회원 가입
     * */
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }
    //회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    //회원 단일 조회
    public Member findOne(Long memberId){
        return memberRepository.findById(memberId).get();
    }


    public void update(Long id, String name) {

        Member member = memberRepository.findById(id).get();
        member.setName(name);


    }
}
