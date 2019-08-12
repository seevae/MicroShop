package com.qi.storeApp.mapper;

import com.qi.storeApp.po.Order;

import java.util.List;



/**
 * OrderMapper 数据访问类
 */
public interface OrderMapper {

    //保存订单信息
    void saveOrder(Order order);

    //根据用户id获取该用户所有的订单信息
    List<Order> getOrderByUserId(int userId);

}