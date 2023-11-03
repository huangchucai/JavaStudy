package com.hcc.spring.mvc.excpetion;

public class BusinessException extends RuntimeException {
  public BusinessException(String message) {
    super(message);
  }
}
