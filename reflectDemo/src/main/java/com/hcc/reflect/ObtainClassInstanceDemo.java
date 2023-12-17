package com.hcc.reflect;


/**
 * 如何获取Class类对象
 */
public class ObtainClassInstanceDemo {
    public static void main(String[] args) {
        // 方法1： .class
        Class<String> stringClazz1 = String.class;
        Class<Animal> animalClazz1 = Animal.class;
        System.out.println("String clazz 1: " + stringClazz1);
        System.out.println("String animalClazz 1: " + animalClazz1);

        // 方法2： 使用对象的getClass()方法
        String s = "hello wordl";
        Animal animal = new Animal("hcc");
        Class<? extends String> stringClazz2 = s.getClass();
        Class animalClazz2 = animal.getClass();
        System.out.println("String clazz 2: " + stringClazz2);
        System.out.println("String animalClazz 2: " + animalClazz2);

        // 方法3： 使用Class.forName()
        try {
            Class<?> stringClazz3 = Class.forName("java.lang.String");
            Class<?> animalClazz3 = Class.forName("com.hcc.reflect.Animal");
            System.out.println("String clazz 3: " + stringClazz3);
            System.out.println("String animalClazz 3: " + animalClazz3);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("class not Found");
        }

        // 方法4： 利用classLoader 加载器
        ClassLoader classLoader = ObtainClassInstanceDemo.class.getClassLoader();
        try {
            Class<?> stringClazz4 = classLoader.loadClass("java.lang.String");
            Class<?> animalClazz4 = classLoader.loadClass("com.hcc.reflect.Animal");
            System.out.println("String clazz 4: " + stringClazz4);
            System.out.println("String animalClazz 4: " + animalClazz4);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 特殊的获取Class对象（只能用于基本类型的包装类）
        Class<Integer> intClazz = Integer.TYPE;
        Class<Boolean> booleanClass = Boolean.TYPE;
        System.out.println("Integer clazz: " + intClazz);
        System.out.println("booleanClass clazz: " + booleanClass);


        /**
         * 每个类在JVM中只有一个Class对象
         */
        String s1 = "Java";
        String s2 = "World";
        Class s1Clazz = s1.getClass();
        Class s2Clazz = s2.getClass();
        System.out.println(" == " + (s1Clazz == s2Clazz));
        System.out.println(" == " + (s1Clazz.equals(s2Clazz)));

    }

}

