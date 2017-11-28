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
 * Description: 存储角色信息
 */
@Data
@ToString
public class Role {

    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleDescription;

}
