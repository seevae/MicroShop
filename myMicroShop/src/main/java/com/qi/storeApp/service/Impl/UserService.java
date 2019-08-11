package com.qi.storeApp.service.Impl;/*
    name zhang;
    */

import com.qi.storeApp.mapper.UserMapper;
import com.qi.storeApp.po.User;
import com.qi.storeApp.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserService implements UserServiceI {

    @Autowired
    private UserMapper userMapper;

    //根据用户输入的账号以及密码获取用户的信息
    public User findUserByNameAndPass(User user) {
        User u = userMapper.findUserByNameAndPass(user);
        return u;
    }
}
