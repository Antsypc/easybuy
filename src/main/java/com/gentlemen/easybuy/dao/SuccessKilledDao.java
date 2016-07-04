package com.gentlemen.easybuy.dao;

import com.gentlemen.easybuy.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

/**
 * @author ants_ypc
 * @version 1.0 7/4/16
 */
public interface SuccessKilledDao {

    /**
     * 插入购买明细,可过滤重复(数据库有联合主键)
     *
     * @param seckilledId
     * @param userPhone
     * @return
     */
    int insertSuccessKilled(@Param("seckilledId") long seckilledId, @Param("userPhone") long userPhone);

    /**
     * 根据ID查询SuccessKilled并携带秒杀产品对象实体
     *
     * @param seckilledId
     * @param userPhone
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckilledId") long seckilledId, @Param("userPhone") long userPhone);
}
