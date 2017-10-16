package model;

import enums.StaffRole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Staff {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String surname;
    private String phone;

    @Enumerated(EnumType.STRING)
    private StaffRole role;

    @ManyToOne
    private BikePoint workplace;

    @OneToMany(mappedBy = "master")
    private List<Repair> repair = new ArrayList<Repair>();

    public Staff(String name, String surname, String phone, BikePoint workplace) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.workplace = workplace;
    }
}
