package dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class StaffDAOImpl implements StaffDAO{
    @PersistenceContext
    private EntityManager entityManager;
}
