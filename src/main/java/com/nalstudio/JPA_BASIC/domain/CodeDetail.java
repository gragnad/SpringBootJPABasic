package com.nalstudio.JPA_BASIC.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(of="codeDetailNo")
@ToString
@Entity
@Table(name = "codeDetail")
public class CodeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeDetailNo;

    private String codeValue;

    private String codeName;
    private int sortSeq;
    private String useYn = "Y";

    @CreationTimestamp
    private LocalDateTime regDate;
    @UpdateTimestamp
    private LocalDateTime updDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_code", insertable = false, updatable = false)
    private CodeGroup codeGroup;
}
