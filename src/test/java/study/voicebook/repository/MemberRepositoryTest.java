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
import study.voicebook.entity.OpenType;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;


@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {

    @Autowired
    EntityManager em;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    Buy_ProductRepository buy_productRepository;
    @Test
    public void memberTest() {
        Member member = new Member("jyt5768", "1234", "정연태", "010-0000-0000", "jyt5768@gmail.com", "연태", MemberType.MEMBER);
        memberRepository.save(member);
        buy_productRepository.save(new Buy_Product(OpenType.NOT_OPEN, LocalDateTime.now(), LocalDateTime.now(), 0, member.getSite_id()));
    }
}