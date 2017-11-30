package com.cnty.auto;

import com.cnty.auto.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoSaleApplicationTests {

    @Resource
	private UserService userService;

	@Test
	public void contextLoads() {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        User user = new User();
//        user.setUserName("cc");
//        user.setUserPassword(encoder.encode("123456"));
//        userService.saveUser(user);

        Instant epoch = Instant.EPOCH;
        Instant max = Instant.MAX;
        Instant min = Instant.MIN;
        Instant now = Instant.now();
        System.out.println("now.getEpochSecond() = " + now.getEpochSecond());
        System.out.println("now.getNano() = " + now.getNano());
        System.out.println("now = " + now);
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        System.out.println("epoch = " + epoch);

        // Instant时间格式化
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        String time_str = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        // Date时间格式化
        // Date date = Calendar.getInstance().getTime();
        // String time_str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date);
        System.out.println("time_str = " + time_str);
    }


}
