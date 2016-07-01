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


    /**
     * 获取所有订单
     * @return List
     */
    @Override
    public List<Orders> getAllOrders() {
        return ordersDao.getAllOrders();
    }

    /**
     * 用户添加订单到购物车
     * @param orders Orders订单对象
     * @return 是否添加成功
     */
    @Override
    public int addOrder(Orders orders) {
        return ordersDao.addOrder(orders);
    }

    /**
     * 用户支付订单
     * @param id 订单 ID
     * @return 是否更新成功
     */
    @Override
    public boolean payOrder(int id) {
        return ordersDao.payOrder(id);
    }

    /**
     * 用户取消订单
     * @param id 订单 ID
     * @return 是否更新成功
     */
    @Override
    public boolean cancelOrder(int id) {
        return ordersDao.cancelOrder(id);
    }

    /**
     * 更新订单任何信息
     * @param orders 订单对象
     * @return 是否更新成功
     */
    @Override
    public boolean updateOrder(Orders orders) {
        return ordersDao.updateOrder(orders);
    }
}
