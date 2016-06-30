package com.gentlemen.easybuy.service;

import com.gentlemen.easybuy.dao.UserDao;
import com.gentlemen.easybuy.entity.User;
import org.apache.ibatis.annotations.Param;
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
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public int checkUserByPhone(String phone) {
        return userDao.checkUserByPhone(phone);
    }


}
