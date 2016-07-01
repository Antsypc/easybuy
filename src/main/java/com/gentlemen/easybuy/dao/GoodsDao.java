package com.gentlemen.easybuy.dao;

import com.gentlemen.easybuy.entity.Goods;
import org.apache.ibatis.annotations.Param;


import java.util.Date;
import java.util.List;

/**
 * Created by dengfei on 2016/6/30.
 */
public interface GoodsDao {


    Goods getGoodsById(int id);

    /*
     *得到某分类下的全部商品
     * @param categoryName
     * @return
     */
    List<Goods> getGoodsByCategory(String categoryName);

    /*
     *根据商品名查找商品
     *@param goodsName
     *@return
     */
    List<Goods> findGoodsByName(String goodsName);

    /*
     *根据商品价格按降序得到商品
     */
    List<Goods> orderGoodsByPrice();

    /**
     * 获取数据，用于显示到主页
     */
    List<Goods> getGoodsSnap();

    /**
     * 获取所有商品信息
     *
     * @return list
     */
    List<Goods> getAllGoods();

    /**
     * 添加一件商品
     * @param goods Goods
     * @return 是否添加成功
     */
    boolean addGoods(Goods goods);

    /**
     * 更新一件商品
     *
     * @param goods 商品
     * @return 更新成功与否
     */
    boolean updateGoods(Goods goods);

    /**
     * 根据商品 ID 删除商品
     * @param id 商品 ID
     * @return 是否成功删除
     */
    boolean deleteGoods(int id);
}
