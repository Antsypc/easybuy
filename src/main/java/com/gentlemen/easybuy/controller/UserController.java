package com.gentlemen.easybuy.controller;

import com.gentlemen.easybuy.entity.Goods;
import com.gentlemen.easybuy.entity.Orders;
import com.gentlemen.easybuy.service.AdminService;
import com.gentlemen.easybuy.service.GoodsService;
import com.gentlemen.easybuy.service.OrdersService;
import com.gentlemen.easybuy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ants_ypc
 * @version 1.0 6/29/16
 */
@Controller
@RequestMapping("/api/user")
public class UserController {

    private static String SUCCESS = "{\"success\":true, \"message\":\"\"}";

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private GoodsService goodsService;

    /**
     * 临时,不用管
     * @param username
     * @return
     */
    @RequestMapping("/admin/{username}")
    @ResponseBody
    public String getAdmin(@PathVariable String username) {
        System.out.println("admin");
        return adminService.getAdminByName(username).toString();
    }

    /**
     * 获取用户信息
     * @param username 用户名（唯一）
     * @return 返回查找结果
     */
    @RequestMapping(value = "/{username}/profile", method = RequestMethod.GET)
    @ResponseBody
    public String getUser(@PathVariable("username") String username) {
        // 使用Spring默认的Converter有中文乱码问题
        String userInfo = userService.getUserByName(username).toString();
        System.out.println(userInfo);
        return userInfo;
    }


    /**
     * 通过用户id获得用户的订单信息
     * @param username 用户的id
     * @return 返回所有订单信息
     */
    @RequestMapping("/{username}")
    @ResponseBody
    // 用户页面：用于展示用户信息
    public String getOrders(@PathVariable("username") String username) {
        // 这里只是使用临时数据格式，实际要使用json，这里仅仅是测试使用
        List<Orders> ordersList = ordersService.getOrdersByUsername(username);
        System.out.println("ordersList size: " + ordersList.size());
        StringBuffer sb = new StringBuffer("orders");
        for (Orders orders : ordersList) {
            Goods goods = goodsService.getGoodsById(orders.getGid());
            sb.append("[")
                    .append(orders.toString()).append(", ").append(goods.toString())
                    .append("]").append("\n");
        }
        return sb.toString();
    }
}
