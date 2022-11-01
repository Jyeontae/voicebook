package study.voicebook.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.voicebook.entity.Member;
import study.voicebook.entity.MemberType;
import study.voicebook.repository.MemberRepository;

import javax.servlet.http.HttpServletRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void join() {
        Member member = new Member("jyt5768", "1234", "정연태", "010-0000-0000", "jyt5768@gmail.com", "연태다", MemberType.MEMBER);
        Member save = memberRepository.save(member);
        assertThat(save.getSite_id()).isEqualTo("jyt5768");
    }


}