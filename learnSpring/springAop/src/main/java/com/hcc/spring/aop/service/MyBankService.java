package com.hcc.spring.aop.service;


import com.hcc.spring.aop.annotation.MyAnnotation;
import org.springframework.stereotype.Service;

@Service
public class MyBankService {

  @MyAnnotation
  public int inquiryBalance(int id) {
    System.out.println("inquiryBalance 被执行");
    return 1000;
  }

  public void saveMoney(int id, int money) {
    System.out.println("saveMoney 被执行");
  }

  public void withdrawMoney(int id, int money) {
    System.out.println("withdrawMoney 被执行");
  }
}
