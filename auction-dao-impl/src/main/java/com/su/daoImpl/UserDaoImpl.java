package com.su.daoImpl;

import com.su.dao.UserDao;
import com.su.domain.User;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by denisova on 9/27/16.
 */
public class UserDaoImpl implements UserDao{

    List<User> users= new ArrayList<>();

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void add(User user) {
        users.add(user);

    }

    @Override
    public void remove(User user) {
        users.remove(user);
    }

    @PostConstruct
    public void generateSomeUsers(){
        User user1 = new User("oliaLogin", "Ivanova", "Olia");
        User user2 = new User("aniaLogin", "Petrova", "Ania");
        User user3 = new User("petiaLogin", "Sidorov", "Petia");
        User user4 = new User("sashaLogin", "Fomich", "Sash");

        add(user1);
        add(user2);
        add(user3);
        add(user4);

    }
}
