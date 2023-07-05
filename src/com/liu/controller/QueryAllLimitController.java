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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/queryAllLimit")
public class QueryAllLimitController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        Map<Integer,List<User>> map = new HashMap<>();
        PrintWriter writer = resp.getWriter();
        UserService us = new UserServiceImpl();
        String start = req.getParameter("start");
        String page = req.getParameter("page");
//        System.out.println(start);
//        System.out.println(page);

        int i = Integer.parseInt(start);
        int i1 = Integer.parseInt(page);
        Map<String, Object> map1 = us.queryAll(i, i1);
//        System.out.println(map1);
        String string = mapper.writeValueAsString(map1);
        writer.print(string);
    }
}
