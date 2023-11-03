package com.hcc.spring.mvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.hcc.spring.mvc")
@Import({DataSourceConfig.class, MyBatisConfiguration.class, WebConfiguration.class})
@EnableTransactionManagement
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableWebMvc
public class SpringConfiguration {
}
