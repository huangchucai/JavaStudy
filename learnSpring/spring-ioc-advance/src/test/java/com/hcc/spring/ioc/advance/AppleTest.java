package com.hcc.spring.ioc.advance;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

  // 测试bean的生命周期的五步
  // 实例化  -> 属性注入 -> 初始化 -> 使用 -> 销毁
  // 实例化  -> 属性注入 -> bean后处理器before -> 初始化 -> bean后处理器after -> 使用 -> 销毁
  @Test
  public void testBeanLiftCircle5() {
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    Banana banana = applicationContext.getBean("banana", Banana.class);
    System.out.println("使用bean" + banana);
    applicationContext.close();
  }

  // 测试循环依赖
  @Test
  public void testCycleDependency() {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    Orange orange = applicationContext.getBean("orange", Orange.class);
    Watermelon watermelon = applicationContext.getBean("watermelon", Watermelon.class);
    System.out.println(orange);
    System.out.println(watermelon);
  }
}
