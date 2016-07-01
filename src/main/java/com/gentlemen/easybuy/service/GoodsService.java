package com.gentlemen.easybuy.service;

import com.gentlemen.easybuy.dao.GoodsDao;
import com.gentlemen.easybuy.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

    /**
     * 返回的数据数量要小于 15 条
     * @return
     */
    @Override
    public List<Goods> getGoodsSnap() {
        List<Goods> list = goodsDao.getGoodsSnap();
        if (list.size() > 15)
            return list.subList(0, 15);
        else
            return list;
    }

    /**
     * 获取所有商品信息
     * @return
     */
    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.getAllGoods();
    }

    /**
     * 添加一件商品
     * @param goods Goods
     * @return 是否添加成功
     */
    @Override
    public boolean addGoods(Goods goods) {
        return goodsDao.addGoods(goods);
    }

    /**
     * 更新一件商品
     *
     * @param goods 商品
     * @return 更新成功与否
     */
    @Override
    public boolean updateGoods(Goods goods) {
        return goodsDao.addGoods(goods);
    }

    /**
     * 根据商品 ID 删除商品
     * @param id 商品 ID
     * @return 是否成功删除
     */
    @Override
    public boolean deleteGoods(int id) {
        return goodsDao.deleteGoods(id);
    }
}
