package com.qi.storeApp.filter;

import com.qi.storeApp.po.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 过滤器,用来过滤用户请求(.action)
 * 以此判断用户是否登陆
 *      如果已经登陆就放行,未登陆就跳转至登陆页面
 */

public class LoginFilter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        User user = (User)request.getSession().getAttribute("session_user");
        if(user == null){
            request.setAttribute("error_message","您尚未登陆,请登陆后在进行相关操作");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
            return false;
        }else{
            return true;
        }
    }
}
