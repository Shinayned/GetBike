package model;

import components.Schedule;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BikePoints")
public class BikePoint {
    @Id
    @GeneratedValue
    private long id;

    private Integer number;
    private String adress;
    private Date date;
    private Schedule schedule;
    // photo !!!

    @OneToMany(mappedBy = "location")
    private List<Bike> bicycles = new ArrayList<Bike>();

    @OneToMany(mappedBy = "location")
    private List<Accessorie> accessories = new ArrayList<Accessorie>();

    @OneToMany(mappedBy = "location")
    private List<Instrument> instruments = new ArrayList<Instrument>();

    @OneToMany(mappedBy = "workplace")
    private List<Staff> staff = new ArrayList<Staff>();

    private double cashbox;

    public BikePoint(String adress, int number) {
        this.adress = adress;
        this.number = number;
        this.date = new Date(System.currentTimeMillis());
    }

    public List<Bike> getBicycles() {
        return bicycles;
    }

    public Schedule getSchedule() {
        return schedule;
    }
}
