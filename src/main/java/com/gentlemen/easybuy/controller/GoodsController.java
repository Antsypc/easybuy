package com.gentlemen.easybuy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gentlemen.easybuy.entity.Goods;
import com.gentlemen.easybuy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
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

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getSnap(HttpServletResponse response) throws JsonProcessingException {
        System.out.println("`````````````````");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        List<Goods> list = goodsService.getGoodsSnap();
        System.out.println(new ObjectMapper().writeValueAsString(list));
        return new ObjectMapper().writeValueAsString(list);
    }

    /**
     * 获取所有商品信息
     *
     * @return Goods JSON 数组
     * @throws JsonProcessingException
     */
    @RequestMapping(path = "", method = RequestMethod.GET, params = "all=true")
    @ResponseBody
    public String getAllGoods() throws JsonProcessingException {
        List<Goods> list = goodsService.getAllGoods();
        return new ObjectMapper().writeValueAsString(list);
    }

    /**
     * 根据商品 ID 获取某一商品信息
     * @param id 商品 ID
     * @param response HttpServletResponse
     * @return Goods JSON
     * @throws JsonProcessingException
     */
    @RequestMapping(params = "/{id}", method = RequestMethod.GET)
    public String getGoodsById(@PathVariable int id, HttpServletResponse response) throws JsonProcessingException {
        Goods goods = goodsService.getGoodsById(id);
        return new ObjectMapper().writeValueAsString(goods);
    }

    /**
     * 添加一件商品,添加失败状态码为400
     *
     * @param goods Goods
     * @param response HttpServletResponse
     * @throws IOException
     */
    @RequestMapping(params = "", method = RequestMethod.POST)
    @ResponseBody
    public void addGoods(@RequestBody Goods goods, HttpServletResponse response) throws IOException {
        goods.setTime(new Timestamp(new Date().getTime()));
        if (!goodsService.addGoods(goods))
            response.sendError(400);
    }


    /**
     * 更新一件商品,更新失败状态为400
     * @param goods 一件商品
     * @param id 商品 ID
     * @param response HttpServletResponse
     * @throws IOException
     */
    @RequestMapping(params = "/{id}", consumes = "application/json", method = RequestMethod.PUT)
    @ResponseBody
    public void updateGoods(@RequestBody Goods goods, @PathVariable int id, HttpServletResponse response) throws IOException {
        goods.setId(id);
        if (!goodsService.updateGoods(goods))
            response.sendError(400);
    }

    /**
     * 根据商品 ID 删除商品,删除失败状态码设置为400
     *
     * @param id 商品 ID
     * @param response HttpServletResponse
     * @throws IOException
     */
    @RequestMapping(params = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void deleteGoods(@PathVariable int id, HttpServletResponse response) throws IOException {
        if(!goodsService.deleteGoods(id))
            response.sendError(400);
    }
}
