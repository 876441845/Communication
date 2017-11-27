package com.cnty.auto.controller;

import com.cnty.auto.pojo.User;
import com.cnty.auto.service.UserService;
import com.cnty.auto.utils.ResultFormatter;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/27 10:37
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping
    public Map<String, Object> showUser(@RequestParam(value = "offset", defaultValue = "0") Integer offset, @RequestParam(value = "limit", defaultValue = "5") Integer limit) {
        Map<String, Object> result = new HashMap<>(16);
        result.put("offset", offset);
        result.put("limit", limit);
        result.put("users", userService.findUser(result));
        return ResultFormatter.formatResult(200, "SUCCESS", result);
    }

    @PostMapping
    public Map<String,Object> addUser(@RequestBody User user){
        int result = userService.saveUser(user);
        return ResultFormatter.formatResult(200,"SUCCESS",result);
    }
}
