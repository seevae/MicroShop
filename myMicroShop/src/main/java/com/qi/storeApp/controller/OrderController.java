package com.qi.storeApp.controller;/*
    name zhang;
    */

import com.qi.storeApp.po.Order;
import com.qi.storeApp.service.OrderServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceI orderServiceI;

    //提交订单
    @RequestMapping(value = "/orderSubmit")
    public String orderSubmit(String orderInfo){

        orderServiceI.orderSubmit(orderInfo);

        return "redirect:/order/showOrder.action";
    }

    //查询当前用户所有的订单信息
    @RequestMapping(value = "/showOrder")
    public String showOrder(Model model){

        try{
            //根据当前用户的id查询该用户的所有订单信息
            List<Order> orders = orderServiceI.getOrderByUserId();
            model.addAttribute("orders",orders);
        }catch (Exception e){
            e.printStackTrace();
        }

        //重定向至订单列表页面
        return "/order";
    }

}
