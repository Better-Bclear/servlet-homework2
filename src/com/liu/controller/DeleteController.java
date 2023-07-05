package com.liu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.service.UserService;
import com.liu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteById")
public class DeleteController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        UserService us = new UserServiceImpl();
        String id2 = req.getParameter("id");
        System.out.println(id2);
        int id = Integer.parseInt(id2);
        String s = us.deleteById(id);
        writer.print(s);

    }
}
