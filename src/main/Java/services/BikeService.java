package services;

import dao.BikeDAO;
import dao.BikePointDAO;
import dto.OrderDTO;
import dto.OrderedBikeDTO;
import enums.BikeType;
import model.Bike;
import model.BikePoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BikeService {
    @Autowired
    private BikeDAO bikeDAO;

    @Autowired
    private BikePointDAO bikePointDAO;


    @Transactional
    public List<Bike> bikeList(int pointNumber, BikeType type, int height) {
        BikePoint bikePoint = bikePointDAO.get(pointNumber);
        return bikePoint.getBicycles();
    }

    @Transactional
    public List<List<Bike>> getArrayOfBikeList(OrderDTO order) {
        List<List<Bike>> arrayOfBikeList = new ArrayList<>();
        for(OrderedBikeDTO bike : order.getOrderedBikes()) {
            arrayOfBikeList.add(
                    bikePointDAO.getBikesByCriteria(order.getPointNumber(), bike.getType(), bike.getHeight()));
        }
        return arrayOfBikeList;
    }
}
