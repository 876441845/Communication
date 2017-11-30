package com.cnty.auto.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/30 13:32
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@Data
@ToString
public class Order {

    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 商品ID
     */
    private Integer goodsId;
    /**
     * 订单中的商品数量
     */
    private Integer goodsNum;
    /**
     * 订单花费
     */
    private Double orderCost;
    /**
     * 订单花费
     */
    private Integer orderState;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 更新时间
     */
    private Date gmtModified;

}
