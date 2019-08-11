package com.qi.storeApp.service;/*
    name zhang;
    */

import javax.servlet.http.HttpSession;

public interface ShopServiceI {
    //将商品信息加入购物车
    void addArticleToShopCar(HttpSession session, int id, int number);
}
