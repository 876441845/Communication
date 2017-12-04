package com.cnty.auto.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/30 13:41
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@Data
@ToString
public class Bag {

    /**
     * 垃圾袋编号
     */
    private String bagId;
    /**
     * 垃圾袋了类型
     */
    private Integer bagType;
    /**
     * 垃圾袋重量
     */
    private Double bagWeight;
    /**
     * 垃圾袋所属用户ID
     */
    private Integer userId;
    /**
     * 垃圾袋绑定用户的时间
     */
    private Date bindTime;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 更新时间
     */
    private Date gmtModified;

}
