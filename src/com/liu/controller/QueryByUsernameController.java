package com.liu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.entity.User;
import com.liu.service.UserService;
import com.liu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/queryByName")
public class QueryByUsernameController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setContentType("application/json");
            ObjectMapper mapper = new ObjectMapper();
            PrintWriter writer = resp.getWriter();
            UserService us = new UserServiceImpl();
            String name = req.getParameter("name");
            List<User> users = us.queryByUsername(name);
            System.out.println(users);
            String str = mapper.writeValueAsString(users);
            writer.print(str);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
