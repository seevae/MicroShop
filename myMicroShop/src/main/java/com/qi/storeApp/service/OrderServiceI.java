package com.qi.storeApp.service;


import com.qi.storeApp.po.Order;

import java.util.List;

public interface OrderServiceI {

    //提交订单
    void orderSubmit(String orderInfo);

    //根据当前用户的id查询该用户的所有订单信息
    List<Order> getOrderByUserId();

}
