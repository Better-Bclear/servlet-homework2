package com.liu.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/y")
public class icaptchaServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp){

        try {
            LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
            HttpSession session = req.getSession();
            String code = lineCaptcha.getCode();
            session.setAttribute("icaptcha",code);
            lineCaptcha.write(resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
