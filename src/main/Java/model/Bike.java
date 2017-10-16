package model;

import components.LoadList;
import enums.BikeStatus;
import enums.BikeType;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Bikes")
public class Bike {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private Date date;
    private Integer minHeight;
    private Integer maxHeight;
    private LoadList loadList;

    @Enumerated(EnumType.STRING)
    private BikeStatus status;

    @Enumerated(EnumType.STRING)
    private BikeType type;

    @ManyToOne
    private BikePoint location;

    @ManyToMany(mappedBy = "bikes")
    private List<Order> reserves = new ArrayList<Order>();

    @OneToMany(mappedBy = "bike")
    private List<Repair> repairs = new ArrayList<Repair>();

    private String description;

    public Bike(){};

    public Bike(String name, Integer minHeight, Integer maxHeight, BikeType type, BikePoint location, String description) {
        this.name = name;
        this.date = new Date(System.currentTimeMillis());
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.status = BikeStatus.FREE;
        this.type = type;
        this.location = location;
        this.description = description;
    }

    public BikePoint getLocation() {
        return location;
    }

    public LoadList getLoadList() {
        return loadList;
    }
}
