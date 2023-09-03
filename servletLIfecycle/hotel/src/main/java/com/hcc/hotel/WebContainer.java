package com.hcc.hotel;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.*;

public class WebContainer {
    Map<String, String> urlPatternServletClass = new HashMap<>();
    Map<String, Servlet> urlPatternServlet = new HashMap<>();

    /**
     * 启动web容器
     */
    public void start(List<ServletConfiguration> configurationList) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ServletException {
        List<ServletConfiguration> servletNeedToLoadOnStart = new ArrayList<>();

        for (ServletConfiguration servletConfiguration : configurationList) {
            String urlPattern = servletConfiguration.getUrlPattern();
            String servletClass = servletConfiguration.getServletClass();
            urlPatternServletClass.put(urlPattern, servletClass);

            Integer loadOnStartup = servletConfiguration.getLoadOnStartup();
            if (loadOnStartup != null && loadOnStartup >= 0) {
                // loadOnStartup 有优先级概念，数字越小，优先级越高，需要安装优先级的顺序创建Servlet对象
                servletNeedToLoadOnStart.add(servletConfiguration);
            }
        }
        // 按照优先级进行排序(升序排序）
        servletNeedToLoadOnStart.sort(Comparator.comparing(v -> v.getLoadOnStartup()));
        // 创建Servlet对象
        for (ServletConfiguration servletConfiguration : servletNeedToLoadOnStart) {
            String servletClass = servletConfiguration.getServletClass();
            createServletObj(servletConfiguration.getUrlPattern(), servletClass);
//            Class clazz = Class.forName(servletClass);
//            Object obj = clazz.newInstance();
//            Servlet servlet = (Servlet) obj;
//            // Servlet对象创建后，需要调用init
//            servlet.init(null);
//            urlPatternServlet.put(servletConfiguration.getUrlPattern(), servlet);
        }

    }

    private Servlet createServletObj(String urlPattern, String servletClass) throws ClassNotFoundException, IllegalAccessException, InstantiationException, ServletException {
        Class clazz = Class.forName(servletClass);
        Object obj = clazz.newInstance();
        Servlet servlet = (Servlet) obj;
        servlet.init(null);
        urlPatternServlet.put(urlPattern, servlet);
        return servlet;
    }

    /**
     * 执行请求(根据用户的请求，找到对应的Servlet对象，然后调用service方法)
     */
    public void doService(String urlPattern, ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 情况一：如果请求路径和 Servlet 对象的映射关系已经存在。 直接获取 Servlet 对象，调用 service 方法
        if (urlPatternServlet.containsKey(urlPattern)) {
            Servlet servlet = urlPatternServlet.get(urlPattern);
            servlet.service(servletRequest, servletResponse);
            return;
        }
        // 情况二：如果请求路径和 Servlet 对象之间的映射关系还不存在，但是请求路径和 Servlet 类名之间的映射关系存在，那么创建 Servlet 对象， 并调用其 service方法
        if (urlPatternServletClass.containsKey(urlPattern)) {
            String servletClass = urlPatternServletClass.get(urlPattern);
            Servlet servlet = createServletObj(urlPattern, servletClass);
            servlet.service(servletRequest, servletResponse);
            return;
        }
        // 情况三：如果用户输入的请求不存在，无法处理用户请求
        System.out.println("请求路径不存在，无法处理用户请求");

    }

    /**
     * 停止web容器
     */
    public void close() {
        // 销毁所有的Servlet对象
        for (Servlet servlet : urlPatternServlet.values()) {
            servlet.destroy();
        }
    }
}
