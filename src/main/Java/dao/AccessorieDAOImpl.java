package dao;

import model.Accessorie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AccessorieDAOImpl implements AccessorieDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Accessorie accessorie) {
        entityManager.persist(accessorie);
    }

    @Override
    public void delete(Accessorie accessorie){
        entityManager.remove(accessorie);
    }

    @Override
    public Accessorie find(long id){
        return entityManager.getReference(Accessorie.class, id);
    }
}
