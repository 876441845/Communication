package com.cnty.auto.service.impl;

import com.cnty.auto.dao.UserDAO;
import com.cnty.auto.pojo.Role;
import com.cnty.auto.pojo.User;
import com.cnty.auto.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/24 17:24
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;

    @Override
    public int saveUser(User user) {
        Integer id = user.getUserId();
        // 对密码进行加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (id != null && id != 0) {
            //  更新
            String password = user.getUserPassword();
            if (password != null && !"".equals(password)) {
                user.setUserPassword(encoder.encode(user.getUserPassword()));
            }
            return userDAO.update(user);
        }
        // 添加
        user.setUserPassword(encoder.encode(user.getUserPassword()));
        Random random = new Random();
        StringBuilder cardId = new StringBuilder();
        int cardIdLength = 20;
        // 不考虑重复的概率,10^20概率已经很低了
        for (int i = 0; i < cardIdLength; i++) {
            cardId.append(random.nextInt(10));
        }
        user.setUserCardId(cardId.toString());
        return userDAO.insert(user);
    }

    @Override
    public List<User> findUser(Map<String, Object> condition) {
        return userDAO.select(condition);
    }

    @Override
    public User findUserById(Integer userId) {
        Map<String, Object> condition = new HashMap<>(16);
        condition.put("userId", userId);
        List<User> userList = userDAO.select(condition);
        return (userList == null || userList.size() == 0) ? null : userList.get(0);
    }

    @Override
    public int deleteUser(Integer userId) {
        return userDAO.delete(userId);
    }

    @Override
    public int grantRole(User user, Role role) {
        return userDAO.grantRole(user, role);
    }

    @Override
    public int revokeRole(User user, Role role) {
        return userDAO.revokeRole(user, role);
    }


}
