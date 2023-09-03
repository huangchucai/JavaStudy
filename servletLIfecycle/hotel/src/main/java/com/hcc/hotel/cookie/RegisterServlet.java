package com.hcc.hotel.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName").trim();
        String passWord = req.getParameter("passWord").trim();
        PassWordClass.registerUser(userName, passWord);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("注册成功");
    }
}
