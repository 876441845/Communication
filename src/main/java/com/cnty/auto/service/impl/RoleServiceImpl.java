package com.cnty.auto.service.impl;

import com.cnty.auto.dao.RoleDAO;
import com.cnty.auto.pojo.Role;
import com.cnty.auto.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/28 11:33
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDAO roleDAO;

    @Override
    public int saveRole(Role role) {
        Integer roleId = role.getRoleId();
        if (roleId != null) {
            return roleDAO.update(role);
        }
        return roleDAO.insert(role);
    }

    @Override
    public List<Role> findRole(Map<String, Object> condition) {
        return roleDAO.select(condition);
    }

    @Override
    public Role findRoleById(Integer roleId) {
        Map<String, Object> condition = new HashMap<>(16);
        condition.put("roleId", roleId);
        List<Role> roleList = roleDAO.select(condition);
        return (roleList == null || roleList.size() == 0) ? null : roleList.get(0);
    }

    @Override
    public int deleteRole(Integer roleId) {
        return roleDAO.delete(roleId);
    }
}
