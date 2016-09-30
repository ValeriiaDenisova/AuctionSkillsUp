package com.su.daoImpl;

import com.su.dao.LotDao;
import com.su.domain.Lot;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LotDaoImpl implements LotDao {

    List<Lot> lots = new ArrayList<>();

    @Override
    public List<Lot> getAll() {
        return lots;
    }

    @Override
    public void add(Lot lot) {
        lots.add(lot);
    }

    @Override
    public void remove(Lot lot) {
        lots.remove(lot);
    }
}
