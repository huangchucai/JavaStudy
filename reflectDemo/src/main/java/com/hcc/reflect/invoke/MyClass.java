package com.hcc.reflect.invoke;

public class MyClass {
    int count;

    public MyClass() {
    }

    public MyClass(int count) {
        this.count = count;
    }

    public void doSomeThing() {
        System.out.println("MyClass do some thing");
    }

    public int sum(int num1, String num2) {
        return num1 + Integer.parseInt(num2) + this.count;
    }

    private int sum(String num1, String num2) {
        return Integer.parseInt(num1) + Integer.parseInt(num2) + this.count;
    }

    private static String print(String msg) {
        return msg + "hello world";
    }
}
