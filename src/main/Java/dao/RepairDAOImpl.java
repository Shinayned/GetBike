package dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RepairDAOImpl implements RepairDAO{
    @PersistenceContext
    private EntityManager entityManager;
}
