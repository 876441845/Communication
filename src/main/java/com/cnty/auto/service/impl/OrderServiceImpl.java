package com.cnty.auto.service.impl;

import com.cnty.auto.dao.OrderDAO;
import com.cnty.auto.pojo.Order;
import com.cnty.auto.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/30 16:13
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDAO orderDAO;

    @Override
    public int saveOrder(Order order) {
        String id = order.getOrderId();
        if (id != null) {
            return orderDAO.update(order);
        }
        // 生成订单号
        Random random = new Random();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        id = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        StringBuilder sb = new StringBuilder(id);
        int loopTimes = 6;
        for (int i = 0; i < loopTimes; i++) {
            sb.append(random.nextInt(10));
        }
        // 不考虑可能重复的概率[极其低]
        order.setOrderId(sb.toString());
        order.setGmtCreate(new Date());
        return orderDAO.insert(order);
    }

    @Override
    public List<Order> findOrder(Map<String, Object> condition) {
        return orderDAO.select(condition);
    }

    @Override
    public Order findOrderById(String orderId) {
        Map<String, Object> condition = new HashMap<>(16);
        condition.put("orderId", orderId);
        List<Order> orderList = orderDAO.select(condition);
        return (orderList == null || orderList.size() == 0) ? null : orderList.get(0);
    }

    @Override
    public int deleteOrder(String orderId) {
        return orderDAO.delete(orderId);
    }
}
