package dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrderDAOImpl implements OrderDAO{
    @PersistenceContext
    private EntityManager entityManager;
}
