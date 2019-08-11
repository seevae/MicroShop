package com.qi.storeApp.mapper;

import java.util.List;

import com.qi.storeApp.po.Shopcar;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;


/**
 * ShopcarMapper 数据访问类
 * @author CHUNLONG.LUO
 * @email 584614151@qq.com
 * @date 2019-05-05 21:31:40
 * @version 1.0
 */
public interface ShopcarMapper {

    @Select("select * from ec_shopcar where user_id = #{userId} and article_id = #{id}")
    Shopcar getShopCarByUserIdAndArticleId(@Param("userId") int userId, @Param("id") int id);

    @Update("update ec_shopcar set buynum = #{number} + buynum where user_id = #{userId} and article_id=#{id}")
    void updateShopCar(@Param("userId") int userId, @Param("id") int id, @Param("number") int number);

    @Insert("insert into ec_shopcar(buynum,user_id,article_id) values (#{buynum},#{userId},#{id})")
    void addShopCar(@Param("userId") int userId, @Param("id") int id, @Param("buynum") int number);

    List<Shopcar> getAllShopCarByUserId(int userId);

    @Update("update ec_shopcar set buynum = #{buynum} where user_id = #{userId} and article_id=#{id}")
    void updateShopcar(@Param("userId")int userId, @Param("id") int id,@Param("buynum")int buyNum);
}