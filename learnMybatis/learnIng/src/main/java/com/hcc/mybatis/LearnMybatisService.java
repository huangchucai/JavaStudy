package com.hcc.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class LearnMybatisService {
    public static void main(String[] args) throws IOException {
        // 1. 记载核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 获取sqlSessionFactory 对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取sqlSession对象  用户执行sql
        SqlSession session = sqlSessionFactory.openSession();
        // 执行sql
        Account account = session.selectOne("AccountMapper.selectAccount", 2);
        System.out.println(account);
        // 释放资源
        session.close();
    }
}
