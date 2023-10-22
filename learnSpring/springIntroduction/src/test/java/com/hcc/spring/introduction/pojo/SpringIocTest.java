package com.hcc.spring.introduction.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    @Test
    public void testGetBeanXml() {
        // 1. 获取spring ioc 容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 从Spring Ioc 容器中获取bean
        Object object = applicationContext.getBean("user");
        System.out.println(object);
    }
    @Test
    public  void testGetBeanAnnotation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Object object = applicationContext.getBean("user");
        System.out.println("----testGetBeanAnnotation----" + object);
    }
}
