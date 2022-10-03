package com.nalstudio.JPA_BASIC.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "album")
public class Album implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Temporal(TemporalType.DATE)
    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @Version
    @Column(name = "VERSION")
    private int version;

    @ManyToOne
    @JoinColumn(name = "SINGER_ID")
    private Singer singer;

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("Album - id: %d, Singer id: %d, Title: %s, Release Date: %s",
                id, singer.getId(), title, sdf.format(releaseDate));
    }
}
