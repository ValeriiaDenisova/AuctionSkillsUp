package com.su.auction.service.impl;

import com.su.auction.dao.LotDao;
import com.su.auction.dao.UserDao;
import com.su.auction.dao.ItemDao;
import com.su.auction.service.AuctionService;
import com.su.domain.Item;
import com.su.domain.Lot;
import com.su.domain.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private LotDao lotDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ItemDao itemDao;

    @Override
    public Lot createLot(Item item, User user, BigDecimal startPrice) {
        Lot lot = new Lot();
        lot.setItem(item);
        lot.setOwner(user);
        lot.setStartPrice(startPrice);
        lot.setDatePlaced(new Date());
        itemDao.add(item);
        userDao.add(user);
        lotDao.add(lot);
        return lot;
    }

    @Override
    public List<Lot> getActiveLots() {
        return lotDao.getAll().stream()
                .filter(l -> l.getDateEnd() == null)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getUsers() {
        return userDao.getAll();
    }

    @Override
    public List<Item> getItems() {
        return itemDao.getAll();
    }

    @Override
    public void soutUsers() {
        System.out.println("Users: " + userDao.getAll());
    }

    @Override
    public void placeBid(Lot lot, User bider) {
        BigDecimal newPrice = lot.getCurrentPrice().add(lot.getCurrentPrice().multiply(BigDecimal.valueOf(0.5)));
        placeBid(lot, newPrice, bider);
    }

    @Override
    public void placeBid(Lot lot, BigDecimal newPrice, User bider) {
        BigDecimal currentPrice = lot.getCurrentPrice();
        if (currentPrice == null || currentPrice.compareTo(newPrice) == -1){
            lot.setCurrentPrice(newPrice);
            lot.setBuyer(bider);
        }
    }

    @Override
    public Lot closeLot(Lot lot) {
        lot.setDateEnd(new Date());
        return lot;
    }

}
