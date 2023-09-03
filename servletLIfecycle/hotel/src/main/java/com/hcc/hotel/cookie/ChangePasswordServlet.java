package com.hcc.hotel.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangePasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName").trim();
        String oldPassWord = req.getParameter("oldPassword").trim();
        String newPassWord = req.getParameter("newPassword").trim();
        resp.setContentType("text/html;charset=utf-8");
        if (PassWordClass.verify(userName, oldPassWord)) {
            PassWordClass.registerUser(userName, newPassWord);
            resp.getWriter().write("修改成功");
        } else {
            resp.getWriter().write("用户名密码不匹配");
        }
    }
}
