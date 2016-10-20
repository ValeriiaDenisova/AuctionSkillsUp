package com.su.dao.hibernate;

import com.su.dao.ItemDao;
import com.su.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

@Component
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private EntityManagerFactory emf;

    @Override
    public List<Item> getAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("select i from Item i").getResultList();
    }

    @Override
    public void add(Item entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(entity);

        transaction.commit();
    }

    @Override
    public void remove(Item entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.remove(entity);

        transaction.commit();

    }
}
