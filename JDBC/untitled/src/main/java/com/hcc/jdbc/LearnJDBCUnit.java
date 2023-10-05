package com.hcc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 事务
 */
public class LearnJDBCUnit {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/school";
        String userName = "root";
        String password = "rootroot";
        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        try {
            // 开启事务
            connection.setAutoCommit(false);
            String sql1 = "update student set money = 1111 WHERE id = 1;";
            String sql2 = "update student set money = 2222 WHERE id = 2;";
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
            // 提交事务
            connection.commit();
        } catch (Exception e) {
            // 错误回滚
            connection.rollback();
        }
        statement.close();
        connection.close();

    }
}
