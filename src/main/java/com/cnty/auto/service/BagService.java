package com.cnty.auto.service;

import com.cnty.auto.pojo.Bag;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/30 15:44
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
public interface BagService {

    /**
     * 保存垃圾袋信息
     *
     * @param bag
     * @return
     */
    int saveBag(Bag bag);

    /**
     * 根据条件查询Bag
     *
     * @param condition Bag的键值对对象+offset和limit
     * @return
     */
    List<Bag> findBag(Map<String, Object> condition);

    /**
     * 根据id查询Bag
     *
     * @param bagId
     * @return
     */
    Bag findBagById(Long bagId);

    /**
     * 删除Bag
     *
     * @param bagId
     * @return
     */
    int deleteBag(Long bagId);
}
