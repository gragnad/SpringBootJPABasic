package com.nalstudio.JPA_BASIC.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "board", schema = "japtest")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private Long boardNo;

    @Column(length = 50,name = "title")
    private String title;

    @Column(length = 50, name = "content")
    private String content;

    @Column(length = 50, name = "writer")
    private String writer;

    //@JsonFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    @Column(name = "reg_date")
    private LocalDateTime regDate;
}
