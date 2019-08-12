package com.qi.storeApp.service.Impl;/*
    name zhang;
    */

import com.qi.storeApp.mapper.OrderItemMapper;
import com.qi.storeApp.mapper.OrderMapper;
import com.qi.storeApp.po.Order;
import com.qi.storeApp.po.OrderItem;
import com.qi.storeApp.po.User;
import com.qi.storeApp.service.OrderServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderServiceI {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    //#1_2_216.0#5_1_158.4
    public void orderSubmit(String orderInfo) {
        String[] orderInfos = orderInfo.substring(1).split("#");

        //创建订单对象
        Order order = new Order();
        //下单时间
        order.setCreateDate(new Date());

        //获取Session
        HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();

        //从session中获取用户信息
        int userId = ((User)session.getAttribute("session_user")).getId();

        //指定订单属于哪一个用户
        order.setUserId(userId);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        //设置订单编号
        order.setOrderCode("PO-"+sdf.format(new Date())+userId);

        //定义订单总金额
        double totalPrice = 0.0;

        //创建集合,用于封装订单详情信息
        List<OrderItem> items = new ArrayList<OrderItem>();

        for(String info:orderInfos){
            String[] infos = info.split("_");

            //获取商品id
            int articleId  = Integer.valueOf(infos[0]);
            //购买数量
            int buyNum = Integer.valueOf(infos[1]);

            OrderItem item = new OrderItem();
            item.setArticleId(articleId);
            item.setOrderNum(buyNum);
            //将订单详细记录放入集合
            items.add(item);

            totalPrice += Double.valueOf(infos[2]);
        }

        //指定订单的总金额
        order.setAmount(totalPrice);

        //保存订单信息,之后需要获取订单的id,因为需要将订单的id存放在订单详情中
        orderMapper.saveOrder(order);

        //获取订单主键的值
        int orderId = order.getId();
        for(OrderItem item:items){
            item.setOrderId(orderId);

            //保存订单明细
            orderItemMapper.saveItem(item);

        }
    }

    //根据当前用户的id查询该用户的所有订单信息
    public List<Order> getOrderByUserId() {
        //获取Session
        HttpSession session = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();

        //从session中获取用户信息
        int userId = ((User)session.getAttribute("session_user")).getId();


        return orderMapper.getOrderByUserId(userId);
    }

}
