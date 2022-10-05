package com.nalstudio.JPA_BASIC.domain;

import com.nalstudio.JPA_BASIC.constant.Gender;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.querydsl.binding.QuerydslPredicate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(of="userNo")
//@Table(name = "member", schema = "jpatest")
//@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Member {

    @Id
    //@SequenceGenerator(name = "MEMBER_SEQUENCE_GEN", sequenceName = "seq_member", initialValue = 1, allocationSize = 1)//oracle
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQUENCE_GEN") //oracle
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;


    private String userId;
    private String userPw;
    private String userName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDateTime joinDate;

    @CreationTimestamp
    private LocalDateTime regDate;

    @UpdateTimestamp
    private LocalDateTime updDate;
}
