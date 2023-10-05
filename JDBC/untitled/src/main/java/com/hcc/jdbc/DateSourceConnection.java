package com.hcc.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.HashMap;

public class DateSourceConnection {
    public static Connection getConnection() throws Exception {
        HashMap<String, Object> configMap = new HashMap<String, Object>();
        configMap.put("driverClassName", "com.mysql.cj.jdbc.Driver");
        configMap.put("url", "jdbc:mysql://127.0.0.1:3306/school");
        configMap.put("username", "root");
        configMap.put("password", "rootroot");
        configMap.put("initialSize", "5");
        configMap.put("maxActive", "5");
        configMap.put("maxWait", "1000");
        DataSource dataSource = DruidDataSourceFactory.createDataSource(configMap);
        return dataSource.getConnection();
    }
}
