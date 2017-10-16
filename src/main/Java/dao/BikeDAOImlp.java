package dao;

import model.Bike;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BikeDAOImlp implements BikeDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Bike bike) {
        entityManager.persist(bike);
    }

    @Override
    public void delete(Bike bike){
        entityManager.remove(bike);
    }

    @Override
    public void update(Bike bike) {
        entityManager.merge(bike);
    }

    @Override
    public Bike find(long id){
        return entityManager.getReference(Bike.class, id);
    }
}
