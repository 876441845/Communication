package com.cnty.auto.service;

import com.cnty.auto.pojo.Role;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/28 11:31
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
public interface RoleService {

    /**
     * 保存角色信息
     * @param role
     * @return
     */
    int saveRole(Role role);

    /**
     * 根据条件查询Role
     * @param condition Role的键值对对象+offset和limit
     * @return
     */
    List<Role> findRole(Map<String,Object> condition);

    /**
     * 根据id查询Role
     * @param roleId
     * @return
     */
    Role findRoleById(Integer roleId);

    /**
     * 根据id删除Role
     * @param roleId
     * @return
     */
    int deleteRole(Integer roleId);

}
