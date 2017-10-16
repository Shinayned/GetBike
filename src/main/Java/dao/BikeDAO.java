package dao;

import model.Bike;

import java.util.List;

public interface BikeDAO {
    void add(Bike bike);
    void delete(Bike bike);
    void update(Bike bike);
    Bike find(long id);
}
