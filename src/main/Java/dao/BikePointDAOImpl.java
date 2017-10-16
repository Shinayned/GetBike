package dao;

import enums.BikeType;
import enums.Height;
import model.Bike;
import model.BikePoint;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BikePointDAOImpl implements BikePointDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(BikePoint bikePoint) {
        entityManager.persist(bikePoint);
    }

    @Override
    public void delete(BikePoint bikePoint){
        entityManager.remove(bikePoint);
    }

    @Override
    public BikePoint get(int number){
        Query query = entityManager.createQuery("SELECT p FROM bikepoint p, p.bike b WHERE " +
                "p.number = :number AND " +
                "b.type = :type AND " +
                "b.minHeight >= :height AND " +
                "b.maxHeight <= :height");
        query.setParameter("number", number);
        return (BikePoint) query.getSingleResult();
    }

    @Override
    public List<Bike> getBikesByCriteria(int pointNumber, BikeType bikeType, Height height) {
        return new ArrayList<>();

    }
}
