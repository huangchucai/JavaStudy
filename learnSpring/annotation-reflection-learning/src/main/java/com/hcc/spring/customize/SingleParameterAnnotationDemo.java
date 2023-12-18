package com.hcc.spring.customize;

@SingleParameterAnnotation("java")
public class SingleParameterAnnotationDemo {
    public void doSomething(@SingleParameterAnnotation("name") String s) {
        System.out.println("do something");
    }
}
