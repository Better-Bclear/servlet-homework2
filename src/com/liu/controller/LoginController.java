package com.liu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.entity.User;
import com.liu.service.UserService;
import com.liu.service.UserServiceImpl;

import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp){
        try {
            resp.setContentType("application/json");
//            resp.setCharacterEncoding("utf-8");
            ObjectMapper mapper = new ObjectMapper();
            PrintWriter writer = resp.getWriter();
            UserService us = new UserServiceImpl();
            ServletInputStream inputStream = req.getInputStream();
            User user = mapper.readValue(inputStream, User.class);
            System.out.println(user);
            String login = us.login(user);
            System.out.println(login);
            if(login=="管理账户登录成功"){
                writer.print(login);
                HttpSession session = req.getSession();
                session.setAttribute("username","刘某人");
            }else if(login=="普通用户登录成功"){
                writer.print("普通用户登录成功");
            }else{
                writer.print("登录失败");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
