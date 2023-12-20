package com.hcc.reflect.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvokeDemo {
    public static void main(String[] args) {
        /**
         * 1. 调用public无参数的无返回值方法
         */
        //（1）获取目标类的Class对象
        MyClass obj = new MyClass(10);
        Class<?> clazz = obj.getClass();

        try {
            //（2）获取目标方法的Method对象
            Method doSomeThingMethod = clazz.getMethod("doSomeThing");
            // （3）调用Method中的invoke方法
            Object someThingResult = doSomeThingMethod.invoke(obj);
            System.out.println("someThingResult：" + someThingResult);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        /**
         * 2. 调用public有参数的有返回值方法
         */

        try {
            //（2）获取目标方法的Method对象, 参数类型要对应
            Method sumMethod = clazz.getMethod("sum", int.class, String.class);
            // （3）调用Method中的invoke方法，参数要对应
            Object sumResult = sumMethod.invoke(obj, 1, "2");
            System.out.println("someThingResult：" + sumResult);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        /**
         * 3. 调用private有参数有返回值方法
         */
        //（1）获取目标类的Class对象
        MyClass obj2 = new MyClass();
        try {
            //（2）获取目标方法的Method对象
            Method sumMethod2 = clazz.getDeclaredMethod("sum", String.class, String.class);
            // (3) 调用private方法需要设置accessible属性
            sumMethod2.setAccessible(true);
            // (4) 调用Method中的invoke方法，参数要对应
            Object sumMethod2Result = sumMethod2.invoke(obj2, "21", "12");
            System.out.println("sumMethod2Result：" + sumMethod2Result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        /**
         * 4. 调用Static的方法
         */
        try {
            //（2）获取目标方法的Method对象
            Method printMethod = clazz.getDeclaredMethod("print", String.class);
            // (3) 调用private方法需要设置accessible属性
            printMethod.setAccessible(true);
            // (4) 调用Method中的invoke方法，参数要对应
            Object sumMethod2Result = printMethod.invoke(null, "21");
            System.out.println("sumMethod2Result：" + sumMethod2Result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
