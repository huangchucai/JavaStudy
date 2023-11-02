package com.hcc.spring.mybatis.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.hcc.spring.mybatis")
@Import({DataSourceConfig.class, MyBatisConfiguration.class})
public class SpringConfiguration {
}
