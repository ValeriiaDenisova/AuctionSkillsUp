package com.su.main;

import com.su.service.AuctionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by denisova on 9/28/16.
 */
public class Main {
    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("service-beans.xml");
        AuctionService auctionService = context.getBean(AuctionService.class);

        System.out.println(auctionService.getUsers().size());
    }
}
