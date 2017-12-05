package com.cnty.auto;

import com.cnty.auto.net.Server;
import com.cnty.auto.utils.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/24 13:54
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.cnty.auto.dao")
public class AutoSaleApplication {
	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(AutoSaleApplication.class, args);
		SpringContextUtil.setApplicationContext(app);
		new Server().start();
	}
}
