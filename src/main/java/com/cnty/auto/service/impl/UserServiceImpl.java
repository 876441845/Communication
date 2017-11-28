package com.cnty.auto.service.impl;

import com.cnty.auto.dao.UserDAO;
import com.cnty.auto.pojo.User;
import com.cnty.auto.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if (id != null && id != 0){
            //  更新
            String password = user.getUserPassword();
            if (password!=null&&!"".equals(password)){
                user.setUserPassword(encoder.encode(user.getUserPassword()));
            }
            return userDAO.update(user);
        }
        // 添加
        user.setUserPassword(encoder.encode(user.getUserPassword()));
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
        return userDAO.select(condition) == null ? null : userDAO.select(condition).get(0);
    }

    @Override
    public int deleteUser(Integer userId) {
        return userDAO.delete(userId);
    }


}
