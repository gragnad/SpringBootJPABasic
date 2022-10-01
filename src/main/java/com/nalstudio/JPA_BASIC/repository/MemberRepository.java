package com.nalstudio.JPA_BASIC.repository;

import com.nalstudio.JPA_BASIC.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

/**
 * JPQL : reference Entity By Object oriented query
 * Criteria Query : provide Builder Class for JPQL
 * QueryDSL : same Criteria Query operation, but non-standard opensource Framework
 * -> Domain Specific Language : Dynamic situation handling
 * Native SQL : Direct Use SQL From JPA
 */
public interface MemberRepository extends CrudRepository<Member, Long>{

    //JPQL=============================================
    @Query("SELECT m FROM Member m WHERE m.userId=?1")
    public List<Member> getListWhereUserId(String userId);

    @Query("SELECT m FROM Member m WHERE m.userPw=:userPw")
    public List<Member> getListWhereUserPw(@Param("userPw")String userPw);

    @Query("SELECT m FROM Member m WHERE m.userId =?1 AND m.userPw=?2")
    public List<Member> getListWhereUserIdAndUserPw(String userId, String userPw0);

    @Query("SELECT m FROM Member m WHERE m.userName LIKE %?1%")
    public List<Member> getListLikeUserName(String userName);

    @Query("SELECT m FROM Member m WHERE m.userNo > 0")
    public Collection<Member> getListUserNoGreatThan0();

    @Query("SELECT m FROM Member m WHERE m.userNo > 0")
    public Page<Member> getPage(Pageable pageable);

    @Modifying
    @Query("UPDATE FROM Member m SET m.userName = ?2 WHERE m.userId = ?1")
    public int updateMemberNameById(String userId, String userName);

    @Modifying
    @Query("DELETE FROM Member m WHERE m.userId = ?1")
    public int deleteMemberById(String userId);

    //Basic JPA USER Method============================
    public List<Member> findByUserId(String userId);

    public List<Member> findByUserPw(String userPw);

    public List<Member> findByUserIdAndUserPw(String userId, String userPw);

    public List<Member> findByUserNameContaining(String userName);

    public Collection<Member> findByUserNoGreaterThan(Long userNo);

    public Page<Member> findByUserNoGreaterThan(Long userNo, Pageable pageable);

    public Collection<Member> findByUserNoGreaterThanOrderByUserNoDesc(Long userNo);

    public List<Member> findByUserNoGreaterThanOrderByUserNoDesc(Long userNo, Pageable pageable);

    public List<Member> findMemberByUserId(String userId);
}
