package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RepairList")
public class Repair {
    @Id
    @GeneratedValue
    private long id;

    private Date date;

    @ManyToOne
    private Bike bike;

    @ManyToOne
    private Staff master;

    private double repairCost;

    @Column(nullable = false)
    private String notes;

    public Repair(Bike bike, Staff master, String notes) {
        this.date = new Date(System.currentTimeMillis());
        this.bike = bike;
        this.master = master;
        this.notes = notes;
    }
}
