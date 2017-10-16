package model;

import enums.InstrumentType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Instruments")
public class Instrument {
    @Id
    @GeneratedValue
    private long id;

    private Date date;

    @Enumerated(EnumType.STRING)
    private InstrumentType type;

    @ManyToOne
    private BikePoint location;

    public Instrument(InstrumentType type, BikePoint location) {
        this.date = new Date(System.currentTimeMillis());
        this.type = type;
        this.location = location;
    }
}
