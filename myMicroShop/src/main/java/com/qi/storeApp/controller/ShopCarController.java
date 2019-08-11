package com.qi.storeApp.controller;/*
    name zhang;
    */

import com.qi.storeApp.service.ArticleServiceI;
import com.qi.storeApp.service.ShopServiceI;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/shopCar")
public class ShopCarController {

    @Autowired
    private ShopServiceI shopService;

    @RequestMapping("/addToCar.action")
    public String addShopCar(HttpSession session, @Param("id")int id, @Param("number")int number){
        //商品加入购物车成功之后,立马展示购物车中的商品信息
        shopService.addArticleToShopCar(session,id,number);
        return  null;
    }
}
