package com.hcc.hotel.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="queryEmptyRoomServlet", urlPatterns = "/cookie/queryEmptyRoom")
public class QueryEmptyRoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 校验用户是否已经登录
        String userName = getCookieValue(req, "userName");
        String passWord = getCookieValue(req, "passWord");
        resp.setContentType("text/html;charset=utf-8");
        if (userName == null || passWord == null) {
            resp.sendRedirect("/hotel/login.html");
            return;
        } else {
            // 用户已经登录
            if(PassWordClass.verify(userName, passWord)) {
                // 登录的用户名正确
                System.out.println(userName + "正在查询空房");
                resp.getWriter().write(userName + "正在查询空房");
            } else {
                // 登录的用户名不正确 （1. 清空当前的cookie 2. 重定向到登录页面）
                String path = req.getContextPath();

                Cookie cookie = new Cookie("userName", "");
                cookie.setMaxAge(0);
                cookie.setPath(path);
                resp.addCookie(cookie);

                Cookie cookie2 = new Cookie("passWord", "");
                cookie2.setMaxAge(0);
                cookie.setPath(path);
                resp.addCookie(cookie2);

                resp.sendRedirect("/hotel/login.html");
                return;
            }

        }
    }

    private String getCookieValue(HttpServletRequest req, String name) {
        Cookie[] cookies = req.getCookies();
        if (cookies == null) return null;
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals(name)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
