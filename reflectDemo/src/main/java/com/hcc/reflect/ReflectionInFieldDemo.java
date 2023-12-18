package com.hcc.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectionInFieldDemo {
    public static void main(String[] args) {
        // 获取class
        Class birdClass = Bird.class;
        // 获取所有自身公共属性和继承的属性
        Field[] publicFields = birdClass.getFields();
        for (Field field : publicFields) {
            System.out.println("Public Field：" + field);

            // 变量名
            System.out.println("Public Field Name：" + field.getName());

            // 访问修饰符
            System.out.println("Field modifier：" + Modifier.toString(field.getModifiers()));

            // 数据类型
            System.out.println("public Field type：" + field.getType());
        }

        // 获取所有自身属性
        Field[] fields = birdClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field：" + field);

            // 变量名
            System.out.println("Field Name：" + field.getName());

            // 访问修饰符
            System.out.println("modifier：" + Modifier.toString(field.getModifiers()));

            // 数据类型
            System.out.println("Field type：" + field.getType());
        }

        // 获取单个属性
        try {
            Field ageField = birdClass.getField("age");
            System.out.println("age Field : " + ageField);
            Field sizeField = birdClass.getDeclaredField("size");
            System.out.println("size Field：" + sizeField);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
