package com.su.service;


import com.su.domain.Item;
import com.su.domain.Lot;
import com.su.domain.User;

import java.math.BigDecimal;
import java.util.List;

public interface AuctionService {

    Lot createLot(Item item, User user, BigDecimal startPrice);

    List<Lot> getActiveLots();

    List<User> getUsers();
}
