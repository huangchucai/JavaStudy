package com.hcc.reflect.invoke;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorAccessDemo {
    public static void main(String[] args) {
        // 1. 获取class
        Class<Person> personClass = Person.class;
        // 2. 获取constructor
        try {
            Constructor<Person> personConstructor = personClass.getDeclaredConstructor(Integer.class, String.class);
            // 3. 设置访问权限
            personConstructor.setAccessible(true);
            // 4. 实例化
            Person person = personConstructor.newInstance(10, "hcc");
            System.out.println(person);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
