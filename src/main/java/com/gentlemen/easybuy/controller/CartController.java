package com.gentlemen.easybuy.controller;

import com.gentlemen.easybuy.entity.Orders;
import com.gentlemen.easybuy.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

/**
 * 购物车控制器
 * Created by wang_zhao on 2016/6/30.
 */
@Controller("cartController")
@RequestMapping("/cart")
public class CartController {
    private static String SUCCESS = "{\"success\":true, \"message\":\"\"}";
    @Autowired
    private OrdersService ordersService;

    /**
     * 显示购物车中的信息
     * @param username 用户id
     * @param model 将信息存储到 model 中
     * @return 返回到购物车信息显示页面
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    @ResponseBody
    public String showCart(@PathVariable("username") String username, Map<String, Object> model) {
        List<Orders> cartInfo = ordersService.getCartByUsername(username);
        System.out.println("cartInfo: " + cartInfo);
        model.put("cartInfo", cartInfo);
        return "test-cart";
    }

    /**
     * 取消购物车中的订单
     * @param username 用户id
     * @param ordersId 订单id
     * @return 转向到：购物车信息展示页面
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.POST)
    @ResponseBody
    public String cancelOrders(@PathVariable("username") String username, int ordersId) {
        System.out.println("do cancel");
        ordersService.cancelOrders(username, ordersId);
        return SUCCESS;
    }
}
