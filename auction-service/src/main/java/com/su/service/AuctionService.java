package com.su.service;


import com.su.domain.Item;
import com.su.domain.Lot;
import com.su.domain.User;

import java.math.BigDecimal;
import java.util.List;

public interface AuctionService {

    Lot createLot(Item item, User user, BigDecimal startPrice);

    List<Lot> getActiveLots();

    void placeBid(Lot lot, User bider);

    void placeBid(Lot lot, BigDecimal newPrice, User bider);

    Lot closeLot(Lot lot);

}
