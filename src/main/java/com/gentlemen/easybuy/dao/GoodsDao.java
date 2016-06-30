package com.gentlemen.easybuy.dao;

import com.gentlemen.easybuy.entity.Goods;


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

}
