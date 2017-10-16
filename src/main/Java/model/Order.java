package model;

import enums.BikeStatus;
import enums.OrderStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    private long id;

    private Date orderTime;
    private Date startRentTime;
    private Date endRentTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @ManyToMany
    @JoinTable(
            name = "BikeOrders",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "bike_id", referencedColumnName = "id")}
    )
    private List<Bike> bikes = new ArrayList<Bike>();

    @ManyToMany
    @JoinTable(
            name = "AccessoriesOrders",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "accessory_id", referencedColumnName = "id")}
    )
    private List<Accessorie> accessories = new ArrayList<Accessorie>();

    private double bikesPrice;
    private double accessoriesPrice;
    private double moneyBail;
    private String documentBail;
    private String notes;

    public Order(Date startRentTime, Date endRentTime, ArrayList<Bike> bikes, List<Accessorie> accessories, double bikesPrice, double accessoriesPrice, double moneyBail, String documentBail, String notes) {
        this.orderTime = new Date(System.currentTimeMillis());
        this.startRentTime = startRentTime;
        this.endRentTime = endRentTime;
        this.status = OrderStatus.PROCESSING;
        this.bikes = bikes;
        this.accessories = accessories;
        this.bikesPrice = bikesPrice;
        this.accessoriesPrice = accessoriesPrice;
        this.moneyBail = moneyBail;
        this.documentBail = documentBail;
        this.notes = notes;
    }
}
