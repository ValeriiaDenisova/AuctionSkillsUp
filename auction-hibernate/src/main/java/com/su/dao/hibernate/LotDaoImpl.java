package com.su.dao.hibernate;

import com.su.dao.LotDao;
import com.su.domain.Lot;
import com.su.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class LotDaoImpl implements LotDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Lot> getAll() {
        return em.createQuery("select l from Lot l").getResultList();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(Lot entity) {
        em.persist(entity);
    }

    @Override
    @Transactional
    public void remove(Lot entity) {
        em.remove(entity);
    }

}
