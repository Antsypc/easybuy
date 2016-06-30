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
    List<Orders> getOrdersByUId(@Param("userId") int userId);
    List<Orders> getCartByUId(@Param("userId") int userId);
    void cancelOrders(@Param("userId") int userId, @Param("ordersId") int orderId);
}
