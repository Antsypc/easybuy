package com.gentlemen.easybuy.dao;

import com.gentlemen.easybuy.entity.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wang_zhao on 2016/6/30.
 */
@Repository("ordersDao")
public interface OrdersDao {
    List<Orders> getOrdersByUsername(@Param("username") String username);
    List<Orders> getCartByUsername(@Param("username") String username);
    void cancelOrders(@Param("username") String username, @Param("ordersId") int orderId);
}