package com.hcc.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 特化流 IntStream LongStream DoubleStream
 */
public class SpecialStreamDemo {
    public static void main(String[] args) {
        // 获取范围
        IntStream stream = IntStream.range(1, 6);
        stream.forEach(System.out::println);

        IntStream stream2 = IntStream.rangeClosed(1, 6);
        stream2.forEach(System.out::println);

        LongStream longStream = LongStream.range(100000000L, 100000005L);
        longStream.forEach(longnum -> System.out.println("long number" + longnum));

        IntStream.of(1, 4, 5, 67).forEach(System.out::println);
        LongStream.of(100000003L, 100000004L, 1000990000L).forEach(System.out::println);

        DoubleStream.of(1.25, 168.245, 668.255).filter(d -> d > 1.5).forEach(System.out::println);

        IntStream randomStream = IntStream.generate(() -> {
            Random random = new Random();
            return random.nextInt(1000);
        });
        randomStream.limit(10).forEach(num -> System.out.println("Int number of random：" + num));

        // 普通流 -> 特化流
        List<String> numList = Arrays.asList("1", "323", "233", "5555");
        IntStream intStream = numList.stream().mapToInt(Integer::parseInt);
        intStream.forEach(System.out::println);

        // 特化流 -> 普通流
        DoubleStream doubleStream = DoubleStream.of(0.3252, 0.666, 20.333);
        Stream<Double> boxStream = doubleStream.boxed();
        boxStream.forEach(System.out::println);

        // 特化流之间的转换
        IntStream intStream1 = IntStream.range(200, 213);
        DoubleStream doubleStream1 = intStream1.asDoubleStream().filter(i -> i % 2 == 1);
        doubleStream1.forEach(System.out::println);

        LongStream longStream1 = IntStream.range(200, 213)
                                          .asLongStream()
                                          .filter(i -> i % 2 == 0);
        longStream1.forEach(System.out::println);
    }
}
