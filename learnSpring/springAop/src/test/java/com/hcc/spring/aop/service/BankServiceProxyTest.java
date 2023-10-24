package com.hcc.spring.aop.service;

import com.hcc.spring.aop.configuration.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class BankServiceProxyTest {
  @Test
  public void testProxy() {
    BankService bankService = new BankService();
    BankServiceProxy bankServiceProxy = new BankServiceProxy(bankService);
    // 执行方法
    bankServiceProxy.inquiryBalance(12);
    bankServiceProxy.saveMoney(1, 1000);
    bankServiceProxy.withdrawMoney(3, 2000);
  }

  @Test
  public void testSpringAOP() {
    // 获取spring IOC容器
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    // 获取bean
    MyBankService myBankService = applicationContext.getBean("myBankService", MyBankService.class);
    // 执行方法
    myBankService.inquiryBalance(12);
    myBankService.saveMoney(1, 1000);
    myBankService.withdrawMoney(2,1234);
  }
}
