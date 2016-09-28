package com.su.daoImpl;

import com.su.dao.ItemDao;
import com.su.domain.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denisova on 9/27/16.
 */
public class ItemDaoImpl implements ItemDao {

    List<Item> items = new ArrayList<>();

    @Override
    public List<Item> getAll() {
        return items;
    }

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void remove(Item item) {
        items.remove(item);
    }
}
