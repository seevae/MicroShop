package com.qi.storeApp.mapper;

import com.qi.storeApp.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;


/**
 * UserMapper 数据访问类
 * @author CHUNLONG.LUO
 * @email 584614151@qq.com
 * @date 2019-05-05 21:31:40
 * @version 1.0
 */
public interface UserMapper {

    //根据用户输入的账号以及密码获取用户的信息
    @Select("select * from ec_user where login_name = #{loginName} and password = #{password}")
    User findUserByNameAndPass(User user);

    @Select("select * from ec_user where login_name = #{loginName}")
    User validLoginName(String loginName);

    @Insert("insert into ec_user(login_name,password,name,sex,email,phone,address,create_date,active) values(#{loginName},#{password},#{name},#{sex},#{email},#{phone},#{address},#{createDate},#{active})")
    void saveUser(User user);
}