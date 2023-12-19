package com.hcc.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ReflectionInMethodDemo {
    public static void main(String[] args) {
        Class<Bird> birdClass = Bird.class;

        // 获取所有自身公共方法和继承的公共方法 （public method)
        Method[] method = birdClass.getMethods();
        for (Method m : method) {
            System.out.println("public method：" + m);
            // 注解获取
            Annotation[] annotations = m.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println("annotation：" + annotation);
            }

            // 方法信息
            System.out.println("public method name：" + m.getName());
            System.out.println("public method return type：" + m.getReturnType());

            // 参数信息
            Parameter[] parameters = m.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("public parameter：" + parameter);
                System.out.println("public parameter name：" + parameter.getName());
                System.out.println("public parameter type：" + parameter.getType());
            }

            // 异常信息
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.println("public exception type：" + exceptionType);
            }

            // 访问修饰符
            System.out.println("modifier：" + Modifier.toString(m.getModifiers()));
        }

        // 获取所有自身方法
        Method[] declaredMethods = birdClass.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println("public method：" + m);
            // 注解获取
            Annotation[] annotations = m.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println("annotation：" + annotation);
            }

            // 方法信息
            System.out.println(" method name：" + m.getName());
            System.out.println(" method return type：" + m.getReturnType());

            // 参数信息
            Parameter[] parameters = m.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(" parameter：" + parameter);
                System.out.println(" parameter name：" + parameter.getName());
                System.out.println(" parameter type：" + parameter.getType());
            }

            // 异常信息
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.println("exception type：" + exceptionType);
            }

            // 访问修饰符
            System.out.println("modifier：" + Modifier.toString(m.getModifiers()));
        }
    }

}
