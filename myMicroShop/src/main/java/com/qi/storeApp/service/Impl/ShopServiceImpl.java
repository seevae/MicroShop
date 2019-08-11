package com.qi.storeApp.service.Impl;/*
    name zhang;
    */

import com.qi.storeApp.mapper.ShopcarMapper;
import com.qi.storeApp.po.Shopcar;
import com.qi.storeApp.po.User;
import com.qi.storeApp.service.ShopServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service("ShopCarServiceI")
@Transactional
public class ShopServiceImpl implements ShopServiceI {

    @Autowired
    private ShopcarMapper shopcarMapper;

    //将商品信息加入购物车
    public void addArticleToShopCar(HttpSession session, int id, int number) {
        //从session中获取用户信息
        User user = (User)session.getAttribute("session_user");

        //获取用户的id
        int userId = user.getId();
        //根据用户id和商品id从购物车表中获取相关信息
        Shopcar shopCar = shopcarMapper.getShopCarByUserIdAndArticleId(userId,id);

        if(shopCar != null){
            //表示该商品已经存在与当前用户的购物车中,则进行商品数量的叠加
            shopcarMapper.updateShopCar(userId,id,number);
        }else{
            //该商品不存在当前用户的购物车中
            shopcarMapper.addShopCar(userId,id,number);
        }

    }
}
