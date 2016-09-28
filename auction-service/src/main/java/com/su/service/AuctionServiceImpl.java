package com.su.service;

import com.su.dao.LotDao;
import com.su.dao.UserDao;
import com.su.domain.Item;
import com.su.domain.Lot;
import com.su.domain.User;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Setter
public class AuctionServiceImpl implements AuctionService {

    private LotDao lotDao;
    private UserDao userDao;


    @Override
    public Lot createLot(Item item, User user, BigDecimal startPrice) {
        Lot lot = new Lot();
        lot.setItem(item);
        lot.setOwner(user);
        lot.setStartPrice(startPrice);
        lot.setDatePlaced(new Date());
        lotDao.add(lot);
        return lot;    }

    @Override
    public List<Lot> getActiveLots() {
        return lotDao.getAll().stream().filter(lot -> lot.getDateEnd() == null).collect(Collectors.toList());
    }

    @Override
    public List<User> getUsers() {
        return userDao.getAll();
    }

    }
