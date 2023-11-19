package com.hcc.Stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 生成stream的几种方法
 */
public class StreamConstructorDemo {
    public static void main(String[] args) {
        // 1. 从集合中产生流 -> Collection::stream()
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "orange");
        Stream<String> stream = fruits.stream();

        Set<Integer> integers = new HashSet<>();
        integers.add(100);
        Stream<Integer> integerStream = integers.stream();

        Collection<String> strings = new ArrayList<>();
        Stream<String> stringStream = strings.stream();

        // 2. 从数组中产生流
        Integer[] nums = {1, 2, 3, 4, 5};
        Stream<Integer> numberStream = Arrays.stream(nums);
        numberStream.forEach(System.out::println);

        String[] fruitArray = {"apple", "banana", "cherry", "orange"};
        Stream<String> fruitStream = Arrays.stream(fruitArray, 1, 4);
        fruitStream.forEach(System.out::println);

        // 3. Stream.of -> 直接从值产生流
        Stream<String> fruit2 = Stream.of("apple", "banana", "cherry", "orange");
        fruit2.forEach(System.out::println);

        // 4. Stream.iterate / generate -> 产生无限流
        Stream<Integer> evenStream = Stream.iterate(2, i -> i + 2);
//        evenStream.forEach(System.out::println);

        Stream<String> stringStream1 = Stream.generate(() -> "abc").limit(10);
        stringStream1.forEach(System.out::println);

        // 5. 从文件中产生流
        String filePath = "/Users/huangchucai/data/important/JavaProject/java8Learn/src/main/java/com/hcc/Stream/file.csv";
        try(Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
