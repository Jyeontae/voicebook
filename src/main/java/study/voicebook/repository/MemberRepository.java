package study.voicebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.voicebook.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    Member findByUsername(String username);
}
