package com.qi.storeApp.controller;
import com.qi.storeApp.po.User;
import com.qi.storeApp.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceI userService;

    //处理用户登录请求
    @RequestMapping("userLogin")
    public String userLogin(User user, Model model, HttpSession session){
        //根据用户输入的账号以及密码获取用户的信息
        User u = userService.findUserByNameAndPass(user);
        if(u == null){
            model.addAttribute("error_message","您输入的账号或密码不正确,请核实!");
            //跳转至登陆页面 /WEB-INF/jsp/login.jsp
            return "login";
        }else{
            //将用户信息存放在session中,直接跳转到首页
            session.setAttribute("session_user",u);
            return "redirect:/article/index";
        }
    }

    //用户退出(清除掉用户中的session信息
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //将用户信息从session中清除
        session.removeAttribute("session_user");
        //退出之后重定向到首页
        return "redirect:/article/index";
    }

}
