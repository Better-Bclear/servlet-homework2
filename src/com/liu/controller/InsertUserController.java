package com.liu.controller;

import cn.hutool.poi.excel.sax.AttributeName;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.entity.User;
import com.liu.service.UserService;
import com.liu.service.UserServiceImpl;

import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/add")
public class InsertUserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp){
       try {
           resp.setContentType("application/json");
           ServletInputStream inputStream = req.getInputStream();
           ObjectMapper mapper = new ObjectMapper();
           PrintWriter writer = resp.getWriter();
           UserService us = new UserServiceImpl();
           User user = mapper.readValue(inputStream, User.class);
           System.out.println(user);
           String s = us.regUser(user);
           System.out.println(AttributeName.s);
           if(s == "注册成功"){
               writer.print("添加成功");
           }
       }catch(Exception e){
           e.printStackTrace();
       }
    }
}
