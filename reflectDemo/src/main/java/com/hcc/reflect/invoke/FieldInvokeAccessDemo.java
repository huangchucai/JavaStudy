package com.hcc.reflect.invoke;

import java.lang.reflect.Field;

/**
 * 字段反射
 */
public class FieldInvokeAccessDemo {
    public static void main(String[] args) {
        //1. 获取class
        Person person = new Person();
        //2. 获取对应的属性
        try {
            Field ageField = person.getClass().getDeclaredField("age");
            ageField.setAccessible(true);
            ageField.set(person, 60);
            System.out.println(person);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        // 3. 设置访问的属性
    }
}
