package com.gentlemen.easybuy.dao;

import com.gentlemen.easybuy.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author ants_ypc
 * @version 1.0 6/29/16
 */
@Repository("userDao")
public interface UserDao {
    User getUserById(int id);
    User getUserByName(String username);
    boolean addUser(User user);
    boolean updateUser(User user);
}
