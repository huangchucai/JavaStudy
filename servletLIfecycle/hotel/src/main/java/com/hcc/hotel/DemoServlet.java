package com.hcc.hotel;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class DemoServlet extends MyGenericServlet{
    @Override
    public void init() {
        System.out.println("初始化执行");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println(this + " DemoServlet server is called");
    }
}
