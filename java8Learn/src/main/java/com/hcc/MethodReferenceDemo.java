package com.hcc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 1.使用静态方法的引用
 * 2.使用实例方法引用
 * 3.使用构造方法引用
 */
public class MethodReferenceDemo {
    public static void main(String[] args) {
        // 1. 静态方法的引用
        List<String> arr = Arrays.asList("123", "254", "563", "414", "545");
        List<Integer> integers = arr.stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(integers);

        // 2. 实例方法的引用
        Car car = new Car();
        IntConsumer intConsumer = car::startCar;
        intConsumer.accept(100);

        /**
         * map中需要接受它的基类Car::getSpeed  、String::length
         */
        List<String> arr2 = Arrays.asList("123", "254", "563", "414", "545");

        List<Integer> lengthList = arr.stream().map(String::length).collect(Collectors.toList());
        System.out.println(lengthList);
        List<Car> carList = new ArrayList<>();
        List<Integer> speedList = carList.stream().map(Car::getSpeed).collect(Collectors.toList());

        // 3. 构造方法的引用
        // 无参构造方法
        Supplier<Car> supplierCar = Car::new;
        Car car1 = supplierCar.get();
        System.out.println(car1);
        // 有参构造方法 有一个参数speed  -> 传进去一个int,得到一个Car
        Function<Integer, Car> functionCar = Car::new;
        Car car2 = functionCar.apply(100);
        System.out.println(car2);

    }
}
