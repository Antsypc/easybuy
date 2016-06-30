package com.gentlemen.easybuy.service;

import com.gentlemen.easybuy.dao.GoodsDao;
import com.gentlemen.easybuy.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 处理商品有关操作
 * Created by dengfei on 2016/6/30.
 */
@Service("goodsServer")
public class GoodsServer implements GoodsDao {

    @Autowired
    private GoodsDao goodsDao;

    public List<Goods> getGoodsByCategory(String categoryName) {
        return goodsDao.getGoodsByCategory(categoryName);
    }

    public List<Goods> findGoodsByName(String goodsName) {
        return goodsDao.findGoodsByName(goodsName);
    }


    public List<Goods> orderGoodsByPrice() {
        return goodsDao.orderGoodsByPrice();
    }
}
