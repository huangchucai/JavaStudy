package com.hcc.hotel.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName").trim();
        String passWord = req.getParameter("passWord").trim();
        resp.setContentType("text/html;charset=utf-8");
        if (PassWordClass.verify(userName, passWord)) {
            Cookie cookie = new Cookie("userName", userName);
            String path = req.getContextPath();
            cookie.setPath(path);
            cookie.setHttpOnly(true);
            cookie.setMaxAge(30 * 24 * 60 * 1000);
            resp.addCookie(cookie);


            Cookie cookie2 = new Cookie("passWord", passWord);
            cookie.setPath(path);
            cookie.setHttpOnly(true);
            cookie.setMaxAge(30 * 24 * 60 * 1000);
            resp.addCookie(cookie2);

            resp.getWriter().write("登录成功");
        } else {
            resp.getWriter().write("login failed 失败");
        }
    }
}
