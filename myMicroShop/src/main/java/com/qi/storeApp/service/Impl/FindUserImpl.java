package com.qi.storeApp.service.Impl;/*
    name zhang;
    */

import com.qi.storeApp.mapper.UserMapper;
import com.qi.storeApp.po.User;
import com.qi.storeApp.service.FindUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service("FindUser")
public class FindUserImpl implements FindUser {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUser() {
        return userMapper.findAllUser();
    }
}
