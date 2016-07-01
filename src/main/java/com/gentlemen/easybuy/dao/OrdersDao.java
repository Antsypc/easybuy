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

    /**
     * 获取所有订单
     * @return List
     */
    List<Orders> getAllOrders();

    /**
     * 用户添加订单到购物车
     * @param orders Orders订单对象
     * @return 是否主键
     */
    int addOrder(Orders orders);

    /**
     * 用户支付订单
     * @param id 订单 ID
     * @return 是否更新成功
     */
    boolean payOrder(int id);

    /**
     * 用户取消订单
     * @param id 订单 ID
     * @return 是否更新成功
     */
    boolean cancelOrder(int id);

    /**
     * 更新订单任何信息
     * @param orders 订单对象
     * @return 是否更新成功
     */
    boolean updateOrder(Orders orders);
}
