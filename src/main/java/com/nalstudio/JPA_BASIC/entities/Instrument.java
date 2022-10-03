package com.nalstudio.JPA_BASIC.entities;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "instrument")
public class Instrument {
    @Id
    @Column(name = "INSTRUMENT_ID")
    public String instrumentId;

    @ManyToMany
    @JoinTable(name = "singer_instrument",
                joinColumns = @JoinColumn(name = "INSTRUMENT_ID"),
                inverseJoinColumns = @JoinColumn(name = "SINGER_ID"))
    private Set<Singer> singer = new HashSet<>();

    @Override
    public String toString() {
        return "Instrument :" + getInstrumentId();
    }
}
