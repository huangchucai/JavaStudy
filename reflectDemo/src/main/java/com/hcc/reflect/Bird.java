package com.hcc.reflect;

@Markable("main-bird")
public class Bird<T> extends Animal implements Flying, Comparable<Bird> {
    @Markable("age")
    public int age;
    private int size;

    public Bird() {
    }

    private Bird(int age) {
        this.age = age;
    }

    public Bird(String type, int age, int size) {
        super(type);
        this.age = age;
        this.size = size;
    }

    private boolean canEat() {
        return true;
    }

    public void walk() {
        System.out.println("The bird is walking");
    }

    public Bird(String type, int age) {
        super(type);
        this.age = age;
    }

    @Override
    public void fly() {
        System.out.println("The bird is flying quickly");
    }

    @Override
    public int compareTo(Bird o) {
        return this.age - o.age;
    }
}
