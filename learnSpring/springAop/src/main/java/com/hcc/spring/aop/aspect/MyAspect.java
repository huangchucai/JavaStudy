package com.hcc.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面（切点+通知点）
 */
@Component
@Aspect
public class MyAspect {
  @Before("generalPointCut()")
  public void before() {
    System.out.println("前置增强被执行");
  }

  @After("generalPointCut()")
  public void after() {
    System.out.println("后置增强被执行");
  }

  @AfterReturning("generalPointCut()")
  public void afterReturning() {
    System.out.println("返回通知被执行");
  }

  @AfterThrowing("generalPointCut()")
  public void afterThrowing() {
    System.out.println("异常通知被执行");
  }

//  @Around("execution(* com.hcc.spring.aop.service.MyBankService.*(..))")
  @Around("generalPointCut()")
  public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println("前环绕通知");
    // 执行目标方法
    Object object = joinPoint.proceed();
    System.out.println("后环绕通知");
    return object;
  }

  @Pointcut("@annotation(com.hcc.spring.aop.annotation.MyAnnotation)")
  public void generalPointCut() {

  }
}
