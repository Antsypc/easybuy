package com.gentlemen.easybuy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gentlemen.easybuy.entity.Goods;
import com.gentlemen.easybuy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * Created by dengfei on 2016/7/1.
 */
@Controller("goodsController")
@RequestMapping("/api/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "", method = RequestMethod.GET, consumes = "application/json;charset=utf-8")
    @ResponseBody
    public String getSnap() throws JsonProcessingException {
        System.out.println("`````````````````");
        List<Goods> list = goodsService.getGoodsSnap();
        System.out.println(new ObjectMapper().writeValueAsString(list));
        return new ObjectMapper().writeValueAsString(list);
    }
}
