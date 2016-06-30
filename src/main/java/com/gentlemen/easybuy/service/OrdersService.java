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
    public List<Orders> getOrdersByUId(@Param("userId") int userId) {
        return ordersDao.getOrdersByUId(userId);
    }

    @Override
    public List<Orders> getCartByUId(@Param("userId") int userId) {
        return ordersDao.getCartByUId(userId);
    }

    @Override
    public void cancelOrders(@Param("userId") int userId, @Param("ordersId") int orderId) {
        ordersDao.cancelOrders(userId, orderId);
    }
}
