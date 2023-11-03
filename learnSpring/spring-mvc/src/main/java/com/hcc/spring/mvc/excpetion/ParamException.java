package com.hcc.spring.mvc.excpetion;

public class ParamException extends RuntimeException{
  public ParamException(String message) {
    super(message);
  }
}
