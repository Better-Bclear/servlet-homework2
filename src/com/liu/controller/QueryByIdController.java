package com.liu.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.entity.User;
import com.liu.service.UserService;
import com.liu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/queryById")
public class QueryByIdController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json");
            ObjectMapper mapper = new ObjectMapper();
            PrintWriter writer = resp.getWriter();
            UserService us = new UserServiceImpl();
            ServletInputStream inputStream = req.getInputStream();
            String string = mapper.readValue(inputStream,String.class);
            int i = Integer.parseInt(string);
            User user = us.queryById(i);
            String json = mapper.writeValueAsString(user);
            writer.print(json);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
