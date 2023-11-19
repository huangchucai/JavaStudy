package com.hcc.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        //1. 源
        List<String> list = Arrays.asList("apple", "orange", "banana", "oRed");
        Stream<String> stringSteam = list.stream(); // 最常见的方式

        //2. 中间操作
        Stream<Integer> integerStream = stringSteam.filter(s -> s.length() > 3)
                .filter(s -> s.startsWith("o")).map(String::length);
        List<Integer> list1 = integerStream.collect(Collectors.toList());

        //3. 终止
        list1.forEach(System.out::println);

        // 整体链式调用
        List<Integer> list2 = Arrays.asList("apple", "orange", "banana", "oRed")
                .stream()
                .filter(s -> s.length() > 3)
                .filter(s -> s.startsWith("o"))
                .map(String::length)
                .collect(Collectors.toList());
        list2.forEach(System.out::println);
    }
}
