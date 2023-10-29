package com.hcc.spring.ioc.advance;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class AppleTest {
    @Test
    public void testSingleton() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Apple apple1 = applicationContext.getBean("apple", Apple.class);
        System.out.println("第一个bean: " + apple1);
        Apple apple2 = applicationContext.getBean("apple", Apple.class);
        System.out.println("第二个bean: " + apple2);
    }

    @Test
    public void testFactoryBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        // 获取工厂的bean
        Object apple1 = applicationContext.getBean("&apple");
        System.out.println("第一个bean: " + apple1);
        Object apple2 = applicationContext.getBean("apple");
        System.out.println("第二个bean: " + apple2);
    }
}
