package com.gentlemen.easybuy.dao;

import com.gentlemen.easybuy.entity.Goods;
<<<<<<< HEAD

import java.util.List;

/**
 * Created by dengfei on 2016/6/30.
 */
public interface GoodsDao {

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
=======
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by wang_zhao on 2016/6/30.
 */
@Repository("goodsDao")
public interface GoodsDao {
    Goods getGoodsById(@Param("id") int id);
>>>>>>> coding/dev-wangzhao
}
