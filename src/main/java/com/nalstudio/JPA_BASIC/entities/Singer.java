package com.nalstudio.JPA_BASIC.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "singer")
@NamedQueries({
        @NamedQuery(name = Singer.FIND_ALL, query = "select s from Singer s")
        , @NamedQuery(name = Singer.FIND_SINGER_BY_ID,
                    query="select distinct s from Singer s " +
                            "join fetch s.albums a " +
                            "join fetch s.instruments i " +
                            "where s.id= :id")
        , @NamedQuery(name = Singer.FIND_SINGER_ALL_WITH_ALBUM ,
                      query = "select distinct s from Singer s " +
                              "join fetch s.albums a " +
                              "join fetch s.instruments i "  )
})
public class Singer implements Serializable {

    public static final String FIND_ALL = "Singer.findAll";
    public static final String FIND_SINGER_BY_ID = "Singer.findById";
    public static final String FIND_SINGER_ALL_WITH_ALBUM = "Singer.findAllWithAlbum";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Temporal(TemporalType.DATE)//자바의 date -> sql.date로 매핑
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Version//
    @Column(name = "VERSION")
    private int version;

    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Album> albums = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "singer_instrument",
            joinColumns = @JoinColumn(name = "SINGER_ID"),
            inverseJoinColumns = @JoinColumn(name = "INSTRUMENT_ID"))
    private Set<Instrument> instruments = new HashSet<>();

    @Override
    public String toString() {
        return "Singer - Id: " + id + ", First name: " + firstName
                + ", Last name: " + lastName + ", Birthday: " + birthDate;
    }
}
