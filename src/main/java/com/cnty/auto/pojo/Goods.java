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
 * Description: 存储商品信息
 */
@Data
@ToString
public class Goods {

    /**
     * 商品ID
     */
    private Integer goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品价格
     */
    private double goodsPrice;
    /**
     * 商品兑换所需积分
     */
    private Integer goodsCostPoints;

}
