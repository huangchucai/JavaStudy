package com.hcc;

public class FlyableDemo {
    public static void main(String[] args) {
        /**
         * 1. 匿名内部类
         */
        Flyable flyThing = new Flyable() {
            @Override
            public int fly() {
                return 200;
            }
        };
        int someThingSpeed = flyThing.fly();
        System.out.println("someThingSpeed speed：" + someThingSpeed);

        /**
         * 2. 实例化
         */
        Bird bird = new Bird();
        bird.fly();

        /**
         * 3. lambda
         */
        Flyable flyable = () -> {
            System.out.println("Flight flying");
            System.out.println("Flight flying speed：" + 500);
            return 500;
        };
        flyable.fly();
    }
}

class Bird implements Flyable {

    @Override
    public int fly() {
        System.out.println("bird fly speed：" + 100);
        return 100;
    }
}
