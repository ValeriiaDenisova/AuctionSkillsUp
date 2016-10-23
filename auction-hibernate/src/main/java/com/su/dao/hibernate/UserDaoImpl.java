package com.su.dao.hibernate;

import com.su.dao.UserDao;
import com.su.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAll() {
        return em.createQuery("select u from User u").getResultList();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(User entity) {
        em.persist(entity);

    }

    @Override
    @Transactional
    public void remove(User entity) {
        em.remove(entity);
    }
}
