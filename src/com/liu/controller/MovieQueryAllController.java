package com.liu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.entity.Movie;
import com.liu.service.MovieService;
import com.liu.service.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/queryAllMovie")
public class MovieQueryAllController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        req.setCharacterEncoding("utf-8");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        MovieService ms = new MovieServiceImpl();

        //接受数据
        ServletInputStream inputStream = req.getInputStream();
        List<Movie> list = ms.queryAll();
        String json = mapper.writeValueAsString(list);

        writer.print(json);

    }
}
