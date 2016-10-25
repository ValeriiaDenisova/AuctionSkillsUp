package com.su.auction.dao.hibernate;

import com.su.auction.dao.LotDao;
import com.su.domain.Lot;
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

    public List<Lot> getAll() {
        return em.createQuery("Select l from Lot l").getResultList();
    }

    @Transactional
    public void add(Lot entity) {
        em.merge(entity);
    }

    @Transactional
    public void remove(Lot entity) {
        em.remove(entity);
    }

}
