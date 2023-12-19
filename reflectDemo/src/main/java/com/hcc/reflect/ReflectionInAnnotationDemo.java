package com.hcc.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ReflectionInAnnotationDemo {
    public static void main(String[] args) {
        Class<Bird> birdClass = Bird.class;

        // 获取类上的注解
        Markable markable = birdClass.getAnnotation(Markable.class);
        System.out.println("class annotation：" + markable);
        System.out.println("class annotation value：" + markable.value());

        // 获取属性上的注解
        try {
            Field ageField = birdClass.getDeclaredField("age");
            Annotation ageAnnotation = ageField.getAnnotation(Markable.class);
            System.out.println("age annotation：" + ageAnnotation);
            System.out.println("age annotation value：" + ((Markable) ageAnnotation).value());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }
}
