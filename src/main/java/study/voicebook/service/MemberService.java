package study.voicebook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.voicebook.controller.form.LoginForm;
import study.voicebook.controller.form.MemberForm;
import study.voicebook.dto.MemberListDto;
import study.voicebook.dto.MemberSearchDto;
import study.voicebook.entity.Member;
import study.voicebook.entity.MemberType;
import study.voicebook.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    public Long joinMember(MemberForm memberForm) {
        Member member = new Member(memberForm.getSite_id(), memberForm.getSite_pw(), memberForm.getUsername(), memberForm.getPhone_num(), memberForm.getEmail(), memberForm.getNickname(), MemberType.MEMBER);
        memberRepository.save(member);
        return  member.getId();
    }

    public Boolean loginMember(LoginForm loginForm) {
        Boolean member = memberRepository.loginComp(loginForm.getSite_id(), loginForm.getSite_pw());
        return member;
    }

    public Page<MemberListDto> findMember(MemberSearchDto memberSearchDto, Pageable pageable) {
           return memberRepository.findMemberAll(memberSearchDto, pageable);
    }
}
