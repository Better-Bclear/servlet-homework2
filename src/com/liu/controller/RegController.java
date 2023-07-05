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

@WebServlet("/reg")
public class RegController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp){
       try {
           resp.setContentType("application/json");
           HttpSession session = req.getSession();
           String code = (String)session.getAttribute("icaptcha");
           String id = req.getParameter("id");
           ObjectMapper mapper = new ObjectMapper();
           PrintWriter writer = resp.getWriter();
           UserService us = new UserServiceImpl();
           System.out.println(id);
           System.out.println(code);
           if(!code.equalsIgnoreCase(id)){
               String str = "验证码错误";
               writer.print(str);
               return ;
           }
           ServletInputStream inputStream = req.getInputStream();
           User user = mapper.readValue(inputStream, User.class);
           System.out.println(user);
           String s = us.regUser(user);
           System.out.println(s);
           if(s == "注册成功"){
               writer.print(s);
           }
       }catch(Exception e){
           e.printStackTrace();
       }
    }
}
