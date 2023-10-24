package com.hcc.spring.aop.aspect;

//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class MyLogAspect {
  private static final Logger logger = LoggerFactory.getLogger(MyLogAspect.class);

  @Around("generalPointCut()")
  public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    String packName = joinPoint.getTarget().getClass().getName();
    String methodName = joinPoint.getSignature().getName();
    Object[] args = joinPoint.getArgs();
    String message = String.format("%s执行了%s方法，参数是%s", packName, methodName, Arrays.toString(args));
//    System.out.println(message);
    logger.info(message);
    Object obj = joinPoint.proceed();
    long end = System.currentTimeMillis();
//    System.out.println("执行时间" + (end - start) + "ms");
    logger.debug("执行时间" + (end - start) + "ms");
    return obj;
  }

  @Pointcut("@annotation(com.hcc.spring.aop.annotation.MyLogAnnotation)")
  public void generalPointCut(){

  }
}
