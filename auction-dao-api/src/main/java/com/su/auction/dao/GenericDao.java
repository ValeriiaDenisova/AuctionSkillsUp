package com.su.auction.dao;

import java.util.List;

public interface GenericDao<T> {
    List<T> getAll();
    void add(T entity);
    void remove(T entity);

}
