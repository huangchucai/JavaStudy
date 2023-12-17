package com.hcc.reflect;

import java.util.Random;

public class ObjectCreationDemo {
    public static Object getInstance() {
        Random random = new Random();
        int seed = random.nextInt(3); // 0,1,2
        String className = "";
        switch (seed) {
            case 0:
                className = "java.lang.String";
                break;
            case 1:
                className = "com.hcc.reflect.Animal";
                break;
            case 2:
                className = "java.util.ArrayList";
                break;
            default:
                System.out.println("not action");
        }
        try {
            Class<?> clazz = Class.forName(className);
            return clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        // 动态创建对象
        Class<Animal> clazz = Animal.class;
        try {
            // 1. 要有无参数构造函数
            // 2. 无参数构造器要有访问权限
            Animal animal = clazz.newInstance();
            System.out.println(animal);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 15; i++) {
            System.out.println("intance： " + getInstance());
        }
    }
}
