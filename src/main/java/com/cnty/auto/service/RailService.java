package com.cnty.auto.service;

import com.cnty.auto.pojo.Rail;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/28 11:32
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
public interface RailService {

    /**
     * 保存货轨的信息
     * @param rail
     * @return
     */
    int saveRail(Rail rail);

    /**
     * 根据条件查询Rail
     * @param condition Rail的键值对对象+offset和limit
     * @return
     */
    List<Rail> findRail(Map<String,Object> condition);

    /**
     * 根据联合主键查询Rail
     * @param railId
     * @param machineId
     * @return
     */
    Rail findRailById(Integer railId,Integer machineId);

    /**
     * 删除该机器的所有货轨信息
     * @param machineId
     * @return
     */
    int deleteRail(Integer machineId);

}
