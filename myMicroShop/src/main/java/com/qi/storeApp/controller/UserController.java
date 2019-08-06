package com.qi.storeApp.controller;/*
    name zhang;
    */

import com.qi.storeApp.po.User;
import com.qi.storeApp.service.FindUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private FindUser findUser;

    @ResponseBody
    @RequestMapping("/getUserMsg")
    public String getUsers(){
        List<User> list = findUser.getAllUser();
        System.out.println("数量"+list.size());
        return null;
    }
}
