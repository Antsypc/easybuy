package com.gentlemen.easybuy.service;

import com.gentlemen.easybuy.dao.UserDao;
import com.gentlemen.easybuy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ants_ypc
 * @version 1.0 6/29/16
 */
@Service("userService")
public class UserService implements UserDao {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }
}
