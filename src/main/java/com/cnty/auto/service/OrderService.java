package com.cnty.auto.service;

import com.cnty.auto.pojo.Order;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/11/30 15:44
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
public interface OrderService {

    /**
     * 保存订单信息
     *
     * @param order
     * @return
     */
    int saveOrder(Order order);

    /**
     * 根据条件查询Order
     *
     * @param condition Order的键值对对象+offset和limit
     * @return
     */
    List<Order> findOrder(Map<String, Object> condition);

    /**
     * 根据订单编号查询Order
     *
     * @param orderId
     * @return
     */
    Order findOrderById(String orderId);

    /**
     * 删除订单
     *
     * @param orderId
     * @return
     */
    int deleteOrder(String orderId);
}
