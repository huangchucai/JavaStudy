package com.hcc;

public class Car {
    @Override
    public String toString() {
        return "Car{" + "name='" + name + '\'' + ", speed=" + speed + '}';
    }

    private String name;

    public Car(Integer speed) {
        this.speed = speed;
    }

    public Car(Integer speed, String name) {
        this.speed = speed;
        this.name = name;
    }

    public Car() {
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    private Integer speed;

    int startCar(int speed) {
        System.out.println("Car starting" + speed);
        this.setSpeed(speed * 2);
        return this.speed;
    }

}
