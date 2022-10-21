package study.voicebook.repository;


import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import study.voicebook.dto.MemberListDto;
import study.voicebook.dto.QMemberListDto;
import study.voicebook.entity.MemberType;


import javax.persistence.EntityManager;


import java.util.List;

import static study.voicebook.entity.QMember.*;
import static org.springframework.util.StringUtils.*;

public class MemberRepositoryImpl implements MemberRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public MemberRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Boolean loginComp(String site_id, String site_pw) {
        Boolean result = queryFactory
                .selectFrom(member)
                .where(member.site_id.eq(site_id).and(member.site_pw.eq(site_pw)))
                .fetch().isEmpty();
        return result;
    }

    @Override
    public Page<MemberListDto> findMemberAll(MemberListDto memberListDto, Pageable pageable) {
        List<MemberListDto> fetch = queryFactory
                .select(new QMemberListDto(member.id, member.site_id, member.nickname, member.email, member.phone_num, member.role))
                .from(member)
                .where(site_idEq(memberListDto.getSite_id()),
                        nicknameEq(memberListDto.getNickname()),
                        emailEq(memberListDto.getEmail()),
                        phoneNumEq(memberListDto.getPhone_num()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        long count = fetch.size();
        return new PageImpl<>(fetch, pageable, count);
    }


    private BooleanExpression phoneNumEq(String phone) {
        return hasText(phone) ? member.phone_num.eq(phone) : null;
    }

    private BooleanExpression emailEq(String email) {
        return hasText(email) ? member.email.eq(email) : null;
    }

    private BooleanExpression nicknameEq(String nickname) {
        return hasText(nickname) ? member.nickname.eq(nickname) : null;
    }

    private BooleanExpression site_idEq(String site_id) {
        return hasText(site_id)? member.site_id.eq(site_id) : null;
    }


}
