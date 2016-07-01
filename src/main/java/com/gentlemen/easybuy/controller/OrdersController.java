package com.gentlemen.easybuy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gentlemen.easybuy.entity.Orders;
import com.gentlemen.easybuy.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ants_ypc
 * @version 1.0 7/1/16
 */
@Controller
@RequestMapping("/api/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    /**
     * 获取所有订单
     *
     * @return List<Orders> JSON
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllOrders() throws JsonProcessingException {
        List<Orders> list = ordersService.getAllOrders();
        return new ObjectMapper().writeValueAsString(list);
    }

}
