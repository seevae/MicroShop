package com.qi.storeApp.service.Impl;

import com.qi.storeApp.mapper.UserMapper;
import com.qi.storeApp.po.User;
import com.qi.storeApp.service.UserServiceI;

import com.sun.mail.smtp.SMTPMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.mail.*;
import javax.mail.internet.InternetAddress;

import java.util.Date;

import java.util.Properties;
import java.util.UUID;

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

    public String validLoginName(String loginName) {
        User user = userMapper.validLoginName(loginName);
        if(user != null){
            return "您输入的名称已存在";
        }else {
            return null;
        }
    }

    public void saveUser(User user) throws MessagingException {

        //生成激活码
        String active = UUID.randomUUID().toString();
        user.setCreateDate(new Date());
        user.setActive(active);
        userMapper.saveUser(user);

        //开始发送邮件给用户
        Properties props = new Properties();

        props.setProperty("mail.smtp.host", "smtp.qq.com");

        props.setProperty("mail.smtp.auth", "true");

        Authenticator auth = new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("906435177@qq.com", "ytkdjxoegbfrbbge");
            }
        };

        Session session = Session.getInstance(props,auth);

        SMTPMessage message = new SMTPMessage(session);

        message.setSubject("用户注册激活邮件，请勿回复，按照指引激活");

        message.setContent("<a href='http://127.0.0.1:8080/user/active?activeCode="+user.getActive()+"' target='_blank'>恭喜您注册成功，请点击该链接进行激活，无需回复！</a>", "text/html;charset=utf-8");

        message.setFrom(new InternetAddress("906435177@qq.com"));

        message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));

        Transport.send(message);
    }

    //用户信息激活
    public String active(String activeCode) {

        //根据激活码获取用户信息,如果找不到,说明激活码不正确,或者已经激活过
        User user = userMapper.getUserByActive(activeCode);
        if(user != null){
            userMapper.active(activeCode);
            return "";
        }else{
            return "激活码异常";
        }
    }
}
