package com.cnty.auto.dao;

import com.cnty.auto.pojo.Role;
import com.cnty.auto.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/24 17:22
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@Repository
public interface UserDAO extends BaseDAO<User> {

    /**
     * 授予用户权限
     *
     * @param user 被授予的用户
     * @param role 所授予的角色
     * @return 影响的行数
     */
    int grantRole(User user, Role role);

    /**
     * 撤销用户权限
     *
     * @param user 被撤销的用户
     * @param role 所撤销的角色
     * @return 影响的行数
     */
    int revokeRole(User user, Role role);

}
