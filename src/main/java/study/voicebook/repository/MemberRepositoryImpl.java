package study.voicebook.repository;


import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import study.voicebook.dto.MemberListDto;
import study.voicebook.dto.MemberSearchDto;
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
    public Page<MemberListDto> findMemberAll(MemberSearchDto memberSearchDto, Pageable pageable) {
        List<MemberListDto> fetch = queryFactory
                .select(new QMemberListDto(member.id, member.site_id, member.nickname, member.email, member.phone_num, member.role))
                .from(member)
                .where(site_idEq(memberSearchDto.getSite_id()),
                        nicknameEq(memberSearchDto.getNickname()),
                        emailEq(memberSearchDto.getEmail()),
                        phoneNumEq(memberSearchDto.getPhone_num()),
                        memberTypeEq(memberSearchDto.getRole()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        long count = fetch.size();
        return new PageImpl<>(fetch, pageable, count);
    }

    private BooleanExpression memberTypeEq(MemberType role) {
        return ObjectUtils.isEmpty(role) ? null : member.role.eq(role);
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
