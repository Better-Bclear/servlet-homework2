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
import java.util.List;

@WebServlet("/queryAll")
public class QueryAllController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        UserService us = new UserServiceImpl();
        ServletInputStream inputStream = req.getInputStream();
        List<User> list = us.queryAll();
        String string = mapper.writeValueAsString(list);
        writer.print(string);
    }
}
