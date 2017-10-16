package services;

import dao.BikeDAO;
import model.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TestServ {
    @Autowired
    private BikeDAO bikeDAO;

    @Transactional
    public void addBike(Bike bike) {
        bikeDAO.add(bike);
    }

    @Transactional
    public Bike find(long id) {
       return bikeDAO.find(id);
    }
}
