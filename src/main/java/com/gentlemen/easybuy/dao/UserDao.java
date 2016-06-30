package com.gentlemen.easybuy.dao;

import com.gentlemen.easybuy.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ants_ypc
 * @version 1.0 6/29/16
 */
@Repository("userDao")
public interface UserDao {
    User getUserByName(@Param("username") String username);
    void createUser(@Param("user") User user);
    int checkUserByPhone(@Param("phone") String phone);
    void modifyUser(@Param("user") User user);
}
