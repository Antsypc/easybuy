package com.gentlemen.easybuy.service;

import com.gentlemen.easybuy.dao.OrdersDao;
import com.gentlemen.easybuy.entity.Orders;
import org.apache.ibatis.annotations.Param;
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


    @Override
    public List<Orders> getOrdersByUsername(String username) {
        return ordersDao.getOrdersByUsername(username);
    }

    @Override
    public List<Orders> getCartByUsername(String username) {
        return ordersDao.getCartByUsername(username);
    }

    @Override
    public void cancelOrders( String username, int orderId) {
        ordersDao.cancelOrders(username, orderId);
    }
}
