package com.hcc;

public class Car {
    public Car(Integer speed) {
        this.speed = speed;
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

    @Override
    public String toString() {
        return "Car{" + "speed=" + speed + '}';
    }
}
