package com.nalstudio.JPA_BASIC.repository;

import com.nalstudio.JPA_BASIC.domain.Member;
import com.nalstudio.JPA_BASIC.domain.QMember;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
//https://github.com/Youngerjesus/Querydsl
@Repository
public class MemberJPAQuerydslRepository {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    public MemberJPAQuerydslRepository(EntityManager em) {
        this.em = em;
        this.queryFactory = new JPAQueryFactory(em);
    }

    public void save(Member member) {
        em.persist(member);
    }

    public List<Member> findAll_dsl() {
        return queryFactory
                .selectFrom(QMember.member)
                .fetch();
    }

    public List<Member> findByUserId(String userId) {
        return queryFactory
                .selectFrom(QMember.member)
                .where(QMember.member.userId.eq(userId))
                .fetch();
    }
}
