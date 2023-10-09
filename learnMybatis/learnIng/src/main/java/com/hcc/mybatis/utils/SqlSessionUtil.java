package com.hcc.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
  private static SqlSessionFactory sqlSessionFactory;

  static {
    try {
      // 1. 记载核心配置文件
      String resource = "mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static SqlSession getSqlSession() {
    return sqlSessionFactory.openSession();
  }
}
