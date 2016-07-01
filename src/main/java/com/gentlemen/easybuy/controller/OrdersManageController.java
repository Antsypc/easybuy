package com.gentlemen.easybuy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gentlemen.easybuy.dao.GoodsDao;
import com.gentlemen.easybuy.entity.Goods;
import com.gentlemen.easybuy.entity.Orders;
import com.gentlemen.easybuy.service.GoodsService;
import com.gentlemen.easybuy.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author ants_ypc
 * @version 1.0 7/1/16
 */
@RequestMapping("/api/admin/orders")
public class OrdersManageController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private GoodsService goodsService;

    /**
     * 管理员获取所有订单信息
     * @return List JSON
     * @throws JsonProcessingException
     */
    @RequestMapping(path = "", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getAllOrders() throws JsonProcessingException {
        List<Orders> list = ordersService.getAllOrders();
        return new ObjectMapper().writeValueAsString(list);
    }

    /**
     * 管理员添加一个订单
     * @param orders Orders
     * @param response HttpServletResponse
     * @throws IOException
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void addOneOrder(@RequestBody Orders orders, HttpServletResponse response) throws IOException {
        try {
            Goods goods = goodsService.getGoodsById(orders.getGid());
            orders.setTime(new Timestamp(new Date().getTime()));
            orders.setState(0);
            orders.setTotal(goods.getPrice() * orders.getSum());
            if (ordersService.addOrder(orders) != 0) {
                response.sendError(400);
            }
        } catch (Exception e) {
            response.sendError(400);
        }
    }

    /**
     * 管理员根据订单ID取消订单
     * @param id 订单 ID
     * @param response HttpServletResponse
     * @throws IOException
     */
    @RequestMapping(path = "/{id}", params = "action=cancel")
    @ResponseBody
    public void cancelOrder(@PathVariable int id, HttpServletResponse response) throws IOException {
        if (!ordersService.cancelOrder(id))
            response.sendError(400);
    }

    /**
     * 管理员修改订单
     * @param orders Orders
     * @param response HttpServletResponse
     * @throws IOException
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void updateOrder(@RequestBody Orders orders, HttpServletResponse response) throws IOException {
        orders.setTime(new Timestamp(new Date().getTime()));
        if (!ordersService.updateOrder(orders))
            response.sendError(400);
    }
}
