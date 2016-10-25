package com.su.auction.service.impl;


import com.su.auction.dao.UserDao;
import com.su.auction.service.UserService;
import com.su.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.getAll();
    }

    @Override
    public User createUser(String login, String firstName, String lastName) {
        User user = new User(login, firstName, lastName);
        return user;
    }
}
