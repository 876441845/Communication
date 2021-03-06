package com.cnty.auto.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/24 17:20
 * @since: JDK1.8.0_144
 * @version: X
 * Description: 存储用户信息
 */
@Data
@ToString
public class User {

    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 用户卡号
     */
    private String userCardId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 用户积分
     */
    private double userPoint;
    /**
     * 用户每月剩余垃圾袋
     */
    private int bagNum;

}
