package com.hcc.reflect;

import java.lang.reflect.Constructor;

public class ReflectionInActionDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        // 获取类名
        Class<Bird> birdClass = Bird.class;
        // getName: the name of the class, interface, or other entity represented by this Class object.
        System.out.println("Class name for bird:  " + birdClass.getName());
        // getSimple:  the simple name of the underlying class
        System.out.println("Class name for bird:  " + birdClass.getSimpleName());

        // 获取包名
        Package birdClassPackage = birdClass.getPackage();
        System.out.println("package name for birdClass：" + birdClassPackage);

        // 获取公共的构造函数
        Constructor<?>[] constructors = birdClass.getConstructors();
        for (Constructor constructor :
                constructors) {
            System.out.println("get public constructor" + constructor);
        }
        // 获取全部的构造函数
        Constructor<?>[] constructorsOfAll = birdClass.getDeclaredConstructors();
        for (Constructor constructor :
                constructorsOfAll) {
            System.out.println("get all constructor：" + constructor);
        }
    }
}
