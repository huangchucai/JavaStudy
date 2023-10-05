package com.hcc.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class LearnConnectionPool {
    public static void main(String[] args) throws Exception {
        Connection connection = DateSourceConnection.getConnection();
        int userId = 1;
        String userPassword = "abc";
//        String userPassword = "' or '1' = '1";
        String sql = "select * from user_password where user_id = ? and password = ?";
        PreparedStatement preStatement = connection.prepareStatement(sql);
        preStatement.setInt(1, userId);
        preStatement.setString(2, userPassword);

        System.out.println("sql + " + sql);
        ResultSet resultSet = preStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("通过验证");
        } else {
            System.out.println("没有通过验证");
        }
    }
}
