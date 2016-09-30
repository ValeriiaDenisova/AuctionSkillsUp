package com.su.service;

import com.su.domain.Item;

import java.util.List;

/**
 * Created by denisova on 9/30/16.
 */
public interface ItemService {

    List<Item> getItems();

    Item createItem(String title, String description);

}
