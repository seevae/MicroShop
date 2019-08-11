package com.qi.storeApp.service;/*
    name zhang;
    */

import com.qi.storeApp.po.User;

public interface UserServiceI {

    //根据用户输入的账号以及密码获取用户的信息
    User findUserByNameAndPass(User user);

    //异步校验账号是否存在
    String validLoginName(String loginName);

    //注册用户
    void saveUser(User user);
}
