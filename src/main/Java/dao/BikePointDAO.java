package dao;

import enums.BikeType;
import enums.Height;
import model.Bike;
import model.BikePoint;

import java.util.List;

public interface BikePointDAO {
    void add(BikePoint bikePoint);
    void delete(BikePoint bikePoint);
    BikePoint get(int number);
    List<Bike> getBikesByCriteria(int pointNumber, BikeType bikeType, Height height);
}
