package com.hcc.spring.mybatis.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MyBatisConfiguration {
  /**
   * 定义bean: SqlSessionFactoryBean, 用于生成SqlSessionFactory对象
   * @param dataSource
   * @return
   */
  @Bean
  public SqlSessionFactoryBean sqlSessionFactory(@Autowired DataSource dataSource) {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    // 设置模型类的别名扫描
    sqlSessionFactoryBean.setTypeAliasesPackage("com.hcc.spring.mybatis.pojo");
    // 设置数据源
    sqlSessionFactoryBean.setDataSource(dataSource);
    return sqlSessionFactoryBean;
  }

  /**
   * 定义bean，返回MapperScannerConfiguration 对象
   */
  @Bean
  public MapperScannerConfigurer mapperScannerConfigurer() {
    MapperScannerConfigurer msc = new MapperScannerConfigurer();
    msc.setBasePackage("com.hcc.spring.mybatis.mapper");
    return msc;
  }
}
