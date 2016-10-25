package com.su.auction.main;

import com.su.auction.dao.ItemDao;
import com.su.auction.dao.UserDao;
import com.su.auction.repository.LotRepository;
import com.su.auction.repository.UserRepository;
import com.su.domain.Item;
import com.su.domain.Lot;
import com.su.domain.User;
import com.su.auction.service.AuctionService;
import com.su.auction.service.ItemService;
import com.su.auction.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("main.xml");
        AuctionService auctionService = context.getBean(AuctionService.class);
        UserService userService = context.getBean(UserService.class);
        ItemService itemService = context.getBean(ItemService.class);

        UserRepository userRepository = context.getBean(UserRepository.class);
        LotRepository lotRepository = context.getBean(LotRepository.class);

        User user1 = userService.createUser("oliaLogin", "Ivanova", "Olia");
        User user2 = userService.createUser("aniaLogin", "Petrova", "Ania");
        User user3 = userService.createUser("petiaLogin", "Sidorov", "Petia");
        User user4 = userService.createUser("sashaLogin", "Fomich", "Sash");

        Item item1 = itemService.createItem("clock", "old clock");
        Item item2 = itemService.createItem("car", "red car");

        Lot lot = auctionService.createLot(item1, user1, new BigDecimal(100));
        auctionService.placeBid(lot, new BigDecimal(120), user2);
        auctionService.placeBid(lot, user3);
        auctionService.placeBid(lot, new BigDecimal(200), user4);

        auctionService.closeLot(lot);

        System.out.println();
        System.out.println(lot.getBuyer() + " is WINNER");

        System.out.println("Lots: " + lotRepository.count());
        System.out.println("Users: " + userRepository.count());



    }
}
