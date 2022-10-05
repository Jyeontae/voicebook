package study.voicebook.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.voicebook.entity.Buy_Product;
import study.voicebook.entity.Member;
import study.voicebook.entity.MemberType;

import javax.persistence.EntityManager;
import java.util.Optional;


@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {

    @Autowired
    EntityManager em;
    @Autowired
    MemberRepository memberRepository;
    @Test
    public void memberTest() {
        Member member = new Member("jyt5768", "1234", "정연태", "010-0000-0000", "jyt5768@gmail.com", "연태", MemberType.MEMBER);
        memberRepository.save(member);
        em.flush();
        em.clear();
        Member result = memberRepository.findByUsername("정연태");
        System.out.println("result = " + result.getUsername());
    }
}