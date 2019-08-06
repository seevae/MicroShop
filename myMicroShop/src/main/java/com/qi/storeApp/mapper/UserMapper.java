package com.qi.storeApp.mapper;/*
    name zhang;
    */


import com.qi.storeApp.po.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    public List<User> findAllUser();

}
