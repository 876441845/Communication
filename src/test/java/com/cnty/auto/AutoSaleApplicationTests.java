package com.cnty.auto;

import com.cnty.auto.pojo.User;
import com.cnty.auto.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoSaleApplicationTests {

    @Resource
	private UserService userService;

	@Test
	public void contextLoads() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setUserName("cc");
        user.setUserPassword(encoder.encode("123456"));
        userService.saveUser(user);
    }


}
