package com.hcc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LearnJDBCService {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 获取链接
        String url = "jdbc:mysql://localhost:3306/school";
        String userName = "root";
        String password = "rootroot";
        Connection connection = DriverManager.getConnection(url, userName, password);

        // 3. 定义sql语句
        String sql = "update student set money = 1300 WHERE id = 1;";

        // 4. 执行sql语句
        Statement statement = connection.createStatement();
        int count = statement.executeUpdate(sql);
        System.out.println("更新的数据 " + count + " 条");

        // 5. 释放资源
        statement.close();
        connection.close();

    }
}
