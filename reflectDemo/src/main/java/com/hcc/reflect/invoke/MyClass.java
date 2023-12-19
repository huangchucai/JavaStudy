package com.hcc.reflect.invoke;

public class MyClass {
    int count;

    public MyClass(int count) {
        this.count = count;
    }

    public void doSomeThing() {
        System.out.println("MyClass do some thing");
    }

    public int sum(int num1, String num2) {
        return num1 + Integer.parseInt(num2) + this.count;
    }
}
