package com.su.service.impl;

import com.su.dao.LotDao;
import com.su.domain.Item;
import com.su.domain.Lot;
import com.su.domain.User;
import com.su.service.AuctionService;
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

    private LotDao lotDao;

    @Autowired
    public AuctionServiceImpl(LotDao lotDao) {
        this.lotDao = lotDao;
    }

    @Override
    public Lot createLot(Item item, User user, BigDecimal startPrice) {
        Lot lot = new Lot();
        lot.setItem(item);
        lot.setOwner(user);
        lot.setStartPrice(startPrice);
        lot.setCurrentPrice(startPrice);
        lot.setDatePlaced(new Date());
        lotDao.add(lot);
        return lot;
    }

    @Override
    public List<Lot> getActiveLots() {
        return lotDao.getAll().stream().filter(lot -> lot.getDateEnd() == null).collect(Collectors.toList());
    }

    @Override
    public void placeBid(Lot lot, User bider) {
        BigDecimal newPrice = lot.getCurrentPrice().add(lot.getCurrentPrice().multiply(BigDecimal.valueOf(0.5)));
        placeBid(lot, newPrice, bider);
    }

    @Override
    public void placeBid(Lot lot, BigDecimal newPrice, User bider) {
        BigDecimal currentPrice = lot.getCurrentPrice();
        if (currentPrice.compareTo(newPrice) == -1) {
            lot.setCurrentPrice(newPrice);
            lot.setBuyer(bider);
        }
    }

    @Override
    public Lot closeLot(Lot lot) {
        lot.setDateEnd(new Date());
        return lot;
    }

    public void setLotDao(String lotDao) {
    }

    public void setUserDao(String userDao) {
    }
}
