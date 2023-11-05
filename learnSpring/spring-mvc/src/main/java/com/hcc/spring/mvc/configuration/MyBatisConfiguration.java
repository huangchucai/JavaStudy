package com.hcc.spring.mvc.configuration;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

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
    sqlSessionFactoryBean.setTypeAliasesPackage("com.hcc.spring.mvc.pojo");
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
    msc.setBasePackage("com.hcc.spring.mvc.mapper");
    return msc;
  }

  /**
   * 配置事务管理器
   * @param dataSource
   * @return
   */
  @Bean
  public DataSourceTransactionManager transactionManager(@Autowired DataSource dataSource) {
    DataSourceTransactionManager manager = new DataSourceTransactionManager();
    manager.setDataSource(dataSource);
    return manager;
  }
}
