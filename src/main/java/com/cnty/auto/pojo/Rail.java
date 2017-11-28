package com.cnty.auto.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/24 17:21
 * @since: JDK1.8.0_144
 * @version: X
 * Description: 存储货轨信息
 */
@Data
@ToString
public class Rail {

    /**
     * 货轨ID
     */
    private Integer railId;
    /**
     * 货轨所属机器的ID
     */
    private Integer machineId;
    /**
     * 货轨中放置的商品ID
     */
    private Integer goodsId;
    /**
     * 货轨中放置的商品数量
     */
    private Integer goodsNum;

}
