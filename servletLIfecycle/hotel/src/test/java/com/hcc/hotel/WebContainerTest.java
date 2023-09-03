package com.hcc.hotel;

import org.junit.Test;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WebContainerTest {
    private List<ServletConfiguration> buildConfiguration() {
        // 不配置loadOnStartup
        ServletConfiguration bookRoomServletConfiguration = new ServletConfiguration("/bookRoom", "com.hcc.hotel.BookRoomServlet", null);
        // 配置loadOnStartup 但是小于0
        ServletConfiguration queryRoomServletConfiguration = new ServletConfiguration("/queryRoom", "com.hcc.hotel.QueryRoomServlet", -1);
       // 配置loadOnStartup 但是等于1
        ServletConfiguration checkInServletConfiguration = new ServletConfiguration("/checkIn", "com.hcc.hotel.CheckInServlet", 1);
        // 配置loadOnStartup 但是等于0
        ServletConfiguration checkOutServletConfiguration = new ServletConfiguration("/checkOut", "com.hcc.hotel.CheckOutServlet", 0);
        // 不配置 loadOnStartup
        ServletConfiguration EndServletConfiguration = new ServletConfiguration("/end", "com.hcc.hotel.EndServlet", 0);

        return Arrays.asList(bookRoomServletConfiguration, queryRoomServletConfiguration, checkInServletConfiguration, checkOutServletConfiguration, EndServletConfiguration);
    }

    @Test
    public void testWebContainer() throws ServletException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        // 1. 获取配置信息
        List<ServletConfiguration> configurationList = buildConfiguration();
        // 2. 创建 Web 容器
        WebContainer webContainer = new WebContainer();
        // 3. 启动 Web 容器
        webContainer.start(configurationList);
        // 4. 用户发起请求 - 查询空房
        webContainer.doService("/queryRoom", null, null);
        // 查询预定房间
        webContainer.doService("/bookRoom", null, null);
        // 登记入住
        webContainer.doService("/checkIn", null, null);
        // 退房
        webContainer.doService("/checkOut", null, null);

        // 关闭容器
        webContainer.close();

    }
}
/**
 * 结果(0的优先级比1大）
 * 1. CheckOutServlet init is called
 * 2. EndServlet init is called
 * 3. CheckInServlet init is called
 * QueryRoomServlet init is called
 * 4. queryRoomServlet server is called
 * BookRoomServlet init is called
 * 5. bookRoomServlet server is called
 * 6. CheckInServlet server is called
 * 7 .CheckOutServlet server is called
 */
