package com.qi.storeApp.mapper;

import com.qi.storeApp.po.OrderItem;
import org.apache.ibatis.annotations.Insert;



/**
 * OrderItemMapper 数据访问类
 */
public interface OrderItemMapper {


    //保存订单明细
    @Insert("insert into ec_order_item(order_id,article_id,order_num) values(#{orderId},#{articleId},#{orderNum})")
    void saveItem(OrderItem item);
}