package com.hcc.spring.mvc.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter(filterName = "myFilter2", urlPatterns = "/account/queryAccountV2")
public class MyFilter2 extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter2 before");
        super.doFilter(req, res, chain);
        System.out.println("MyFilter2 after");
    }
}
