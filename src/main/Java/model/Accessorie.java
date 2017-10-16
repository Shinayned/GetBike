package model;

import enums.AccessorieType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Accessories")
public class Accessorie {
    @Id
    @GeneratedValue
    private long id;

    private Date date;

    @Enumerated(EnumType.STRING)
    private AccessorieType type;

    @ManyToOne
    private BikePoint location;

    public Accessorie(AccessorieType type, BikePoint location) {
        this.date = new Date(System.currentTimeMillis());
        this.type = type;
        this.location = location;
    }
}
