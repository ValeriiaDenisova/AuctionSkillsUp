package com.su.auction.daoImpl;

import com.su.auction.dao.ItemDao;
import com.su.domain.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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
