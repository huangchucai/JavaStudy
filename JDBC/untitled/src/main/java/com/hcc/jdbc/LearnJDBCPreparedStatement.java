package com.hcc.jdbc;

import java.sql.*;

/**
 * 事务
 */
public class LearnJDBCPreparedStatement {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/school";
        String userName = "root";
        String password = "rootroot";
        Connection connection = DriverManager.getConnection(url, userName, password);
        int userId = 1;
//        String userPassword = "abc";
        String userPassword = "' or '1' = '1";
        /*
        Statement statement = connection.createStatement();
        String user_password = "' or '1' = '1";
        String sql = "select * from user_password where user_id = " + userId + " and password = '" + user_password + "'";
        */
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

    private static class Account {
        private Integer id;

        private String name;

        private Integer money;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", money=" + money +
                    '}';
        }
    }
}
