package com.gentlemen.easybuy.service;

import com.gentlemen.easybuy.dao.GoodsDao;
import com.gentlemen.easybuy.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wang_zhao on 2016/6/30.
 */
@Service("goodsService")
public class GoodsService implements GoodsDao {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Goods getGoodsById(int id) {
        return goodsDao.getGoodsById(id);
    }

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
