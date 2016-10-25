package com.su.auction.daoImpl;

import com.su.auction.dao.UserDao;
import com.su.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManagerFactory emf;

    public List<User> getAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("select u from User u").getResultList();
    }

    public void add(User entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(entity);

        transaction.commit();
        em.close();
    }

    public void remove(User entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.remove(entity);

        transaction.commit();
        em.close();
    }

}
