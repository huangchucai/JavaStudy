package com.hcc.jdbc;

import java.sql.*;

/**
 * 事务
 */
public class LearnJDBCStatement {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/school";
        String userName = "root";
        String password = "rootroot";
        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
/*        String insertSQL = "insert into student(name, age, province, money) values ('hcc', 18, 'guangzhou', 10000)";
        String updateSQL = "update student set money = 1478 where id = 1";
        String deleteSQL = "delete from student where id = 9";

        int countInsert = statement.executeUpdate(insertSQL);
        int countUpDate = statement.executeUpdate(updateSQL);
        int countDelete = statement.executeUpdate(deleteSQL);

        System.out.println("插入数据" + countInsert + "条" );
        System.out.println("修改数据" + countUpDate + "条" );
        System.out.println("删除数据" + countDelete + "条" );*/


        String querySql = "select * from student WHERE id IN(1,2) order by id desc";
        ResultSet resultSet = statement.executeQuery(querySql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int money = resultSet.getInt("money");
            Account account = new Account();
            account.setId(id);
            account.setMoney(money);
            account.setName(name);
            System.out.println(account);
        }

        statement.close();
        connection.close();
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
