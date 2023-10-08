package com.hcc.mybatis;

import com.hcc.mybatis.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class LearnMybatisService {
    public static void main(String[] args) throws IOException {
        // 1. 记载核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 获取sqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        // 获取sqlSession对象  用户执行sql
        SqlSession session = sqlSessionFactory.openSession();
        AccountMapper accountMapper = session.getMapper(AccountMapper.class);

        // 执行sql
        Account account = accountMapper.selectAccount(4);
        System.out.println(account);

        List<Account> accountList = accountMapper.selectAccountList(500);
        System.out.println(accountList);

       /*
        // 执行sql
        Account account = session.selectOne("AccountMapper.selectAccount", 2);
        System.out.println(account);

        List<Account> accountList = session.selectList("AccountMapper.selectAccountList", 5);
        System.out.println(accountList);

        // 插入数据
        Account insertAccount = new Account();
        insertAccount.setName("Mary");
        insertAccount.setMoney(6000);
        int countInsert = session.insert("AccountMapper.insertAccount", insertAccount);
        System.out.println("插入数据的条数：" + countInsert);

        // 更新数据
        Account updateAccount = new Account();
        updateAccount.setId(2);
        updateAccount.setMoney(8888);
        int countUpdate = session.update("AccountMapper.updateAccount", updateAccount);
        System.out.println("更新数据的条数：" + countUpdate);

        // 删除数据
        int countDelete = session.delete("AccountMapper.deleteAccount", 23);
        System.out.println("删除数据的条数：" + countDelete);*/

        // 提交事务
        session.commit();
        // 释放资源
        session.close();
    }
}
