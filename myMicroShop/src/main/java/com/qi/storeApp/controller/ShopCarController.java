package com.qi.storeApp.controller;/*
    name zhang;
    */

import com.qi.storeApp.po.Shopcar;
import com.qi.storeApp.service.ShopCarServiceI;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/shopCar")
public class ShopCarController {

    @Autowired
    private ShopCarServiceI shopCarService;

    @RequestMapping("/addToCar.action")
    public String addShopCar(HttpSession session, @Param("id")int id, @Param("number")int number){
        //商品加入购物车成功之后,立马展示购物车中的商品信息
        shopCarService.addArticleToShopCar(session,id,number);

        return  "redirect:/shopCar/showShopCar.action";
    }

    //展示购物车中的商品信息
    @RequestMapping("/showShopCar.action")
    public String addShopCar(HttpSession session,Model model){

        //根据用户的id获取该用户的购物详情
        List<Shopcar> shopcars = shopCarService.getAllShopCarByUserId(session);
        model.addAttribute("shopCars",shopcars);


        //遍历集合,计算购物车中商品的总金额
        double totalPrice = 0.0;

        for(Shopcar shopcar:shopcars){
            totalPrice += shopcar.getArticle().getDiscountPrice()*shopcar.getBuynum();
        }

        model.addAttribute("totalPrice",totalPrice);

        return  "shopCar";
    }
}
