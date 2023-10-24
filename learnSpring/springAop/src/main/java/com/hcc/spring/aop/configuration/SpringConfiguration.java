package com.hcc.spring.aop.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.hcc.spring.aop")
@EnableAspectJAutoProxy
public class SpringConfiguration {
}
