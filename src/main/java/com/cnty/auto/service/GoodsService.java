package com.cnty.auto.service;

import com.cnty.auto.pojo.Goods;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/28 9:08
 * @since: JDK1.8.0_144
 * @version: X
 * Description: GoodsService Interface
 */
public interface GoodsService {

    /**
     * 保存商品信息
     * @param goods
     * @return
     */
    int saveGoods(Goods goods);

    /**
     * 根据条件查询Goods
     * @param condition Goods的键值对对象+offset和limit
     * @return
     */
    List<Goods> findGoods(Map<String,Object> condition);

    /**
     * 根据id查询Goods
     * @param goodsId
     * @return
     */
    Goods findGoodsById(Integer goodsId);

    /**
     * 删除Goods
     * @param goodsId
     * @return
     */
    int deleteGoods(Integer goodsId);

}
