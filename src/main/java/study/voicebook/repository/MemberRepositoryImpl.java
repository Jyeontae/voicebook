package study.voicebook.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;



import javax.persistence.EntityManager;


import static study.voicebook.entity.QMember.*;

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

}
