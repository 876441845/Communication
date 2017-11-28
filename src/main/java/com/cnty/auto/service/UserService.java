package com.cnty.auto.service;

import com.cnty.auto.dao.UserDAO;
import com.cnty.auto.pojo.User;

import java.security.PrivateKey;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/24 17:24
 * @since: JDK1.8.0_144
 * @version: X
 * Description: UserService Interface
 */
public interface UserService {

    /**
     * 保存用户信息
     * @param user 用户实体
     * @return 影响的行数
     */
    int saveUser(User user);

    /**
     * 根据条件查询用户
     * @param condition
     * @return 用户集
     */
    List<User> findUser(Map<String, Object> condition);

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findUserById(Integer userId);

    /**
     * 删除用户
     * @param userId
     * @return 影响的行数
     */
    int deleteUser(Integer userId);
}
