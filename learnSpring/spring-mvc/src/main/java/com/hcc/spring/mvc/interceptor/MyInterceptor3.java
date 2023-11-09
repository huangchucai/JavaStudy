package com.hcc.spring.mvc.interceptor;

import com.hcc.spring.mvc.mapper.AccountPOMapper;
import com.hcc.spring.mvc.pojo.AccountPO;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor3 implements HandlerInterceptor {

    @Resource
    private AccountPOMapper accountPOMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor3 preHandle");
        AccountPO accountPO = accountPOMapper.selectByPrimaryKey(1);
        System.out.println(accountPO);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor2 postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor2 afterCompletion");
    }
}
