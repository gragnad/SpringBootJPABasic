package com.nalstudio.JPA_BASIC.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "codeGroup")
@EqualsAndHashCode(of="groupCode")
public class CodeGroup {
    @Id
    @Column(name = "group_code")
    private String groupCode;

    private String groupName;
    private String useYn = "Y";

    @CreationTimestamp
    private LocalDateTime regDate;

    @UpdateTimestamp
    private LocalDateTime updDate;

    @OneToMany(mappedBy = "codeGroup", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CodeDetail> codeDetails;

    //연관관계 편의 메서드
    public void addCodeDetail(CodeDetail codeDetail) {
        codeDetail.setCodeGroup(this);
        this.codeDetails.add(codeDetail);
    }
}
