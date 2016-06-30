package com.gentlemen.easybuy.dao;

import com.gentlemen.easybuy.entity.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by wang_zhao on 2016/6/30.
 */
@Repository("goodsDao")
public interface GoodsDao {
    Goods getGoodsById(@Param("id") int id);
}
