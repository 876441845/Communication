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
 * Description: 存储机器信息
 */
@Data
@ToString
public class Machine {

    /**
     * 机器ID
     */
    private Integer machineId;
    /**
     * 机器编号
     */
    private String machineNo;
    /**
     * 机器类型
     */
    private Integer machineType;
    /**
     * 机器放置地点
     */
    private String machineLocation;

}
