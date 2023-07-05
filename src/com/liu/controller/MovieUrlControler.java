package com.liu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@MultipartConfig
@WebServlet("/url")
public class MovieUrlControler extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("application/json");
            Part file = req.getPart("url");
            System.out.println(file);
            String submittedFileName = file.getSubmittedFileName();
            PrintWriter writer = resp.getWriter();
            InputStream inputStream = file.getInputStream();
            String realPath = req.getServletContext().getRealPath("/file/upload/movies");
            System.out.println(realPath);
            FileOutputStream outputStream = new FileOutputStream(realPath + "//" + file.getSubmittedFileName());
            int a = 0;
            while ((a = inputStream.read()) != -1) {
                outputStream.write(a);
            }
            inputStream.close();
            outputStream.close();
            writer.print("../file/upload/movies/" + submittedFileName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
