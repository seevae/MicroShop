package com.qi.storeApp.service;/*
    name zhang;
    */

import com.qi.storeApp.po.Shopcar;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ShopCarServiceI {
    //将商品信息加入购物车
    void addArticleToShopCar(HttpSession session, int id, int number);


    List<Shopcar> getAllShopCarByUserId(HttpSession session);
}
