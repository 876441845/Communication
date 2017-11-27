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
 * Description:
 */
@Data
@ToString
public class Goods {

    private Integer goodsId;
    private String goodsName;
    private double goodsPrice;
    private Integer goodsCostPoints;

}
