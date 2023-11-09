package com.hcc.spring.springboot.excpetion;

public class ParamException extends RuntimeException{
  public ParamException(String message) {
    super(message);
  }
}
