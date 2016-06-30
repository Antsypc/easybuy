package com.gentlemen.easybuy.service;

import com.gentlemen.easybuy.dao.OrdersDao;
import com.gentlemen.easybuy.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wang_zhao on 2016/6/30.
 */
@Service("ordersService")
public class OrdersService implements OrdersDao {
    @Autowired
    private OrdersDao ordersDao;

    public List<Orders> getOrdersByUserId(int uid) {
        return ordersDao.getOrdersByUserId(uid);
    }
}
