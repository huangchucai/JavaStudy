package com.hcc.Stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediaOperationDemo {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("e 123", "rw 145", "wrs 456", "rrwe 789", "wrrs 47");

        // filter: 用于筛选流中满足特定条件的元素 (中间操作）
        Stream<String> stream = Stream.of("qwew", "ewe", "rewr", "ewrf");
        Stream<String> filterStream = stream.filter(s -> s.startsWith("e"));
        List<String> strings = filterStream.collect(Collectors.toList());
        strings.forEach(System.out::println);

        // map: T -> R 对流中的每一个元素进行操作
        Stream<Integer> lengthStream = stringList.stream().map(String::toUpperCase)
                                                 .filter(s -> s.startsWith("W"))
                                                 .map(String::length);
        lengthStream.forEach(System.out::println);

        // flatMap: 将流中的每个元素转化为其他流，然后再将所有这些流合并连接成一个流
        stringList.stream()
                  .map(String::length)
                  .forEach(length -> System.out.println("the str length：" + length));

        stringList.stream()
                  .flatMap(s -> Arrays.stream(s.split(" ")))
                  .forEach(s -> System.out.println("Str after flat map：" + s));

        stringList.stream()
                  .flatMap(s -> Arrays.stream(s.split(" ")))
                  .map(String::length)
                  .forEach(length -> System.out.println("the str length：" + length));

        List<List<String>> nestList = Arrays.asList(
                Arrays.asList("12fsf", "dsf"),
                Arrays.asList("12fsf", "dsf"),
                Arrays.asList("12fsf", "dsf")
        );
        nestList.stream().flatMap(Collection::stream).forEach(System.out::println);
        nestList.stream().flatMap(list -> list.stream().filter(s -> s.length() > 4)).forEach(System.out::println);

        Stream<Stream<String>> nestStream = Stream.of(
                Stream.of("a", "b"),
                Stream.of("c", "d"),
                Stream.of("e", "f", "g")
        );
        nestStream.flatMap(stream1 -> stream1).forEach(System.out::println);

        // distinct : 对流中的元素去重
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 4, 5, 2);
        numbers.stream().distinct().forEach(System.out::println);

        // sorted： 排序
        numbers.stream().sorted().forEach(System.out::println);

        // skip：跳过流中的前几个元素
        numbers.stream().skip(2).distinct().forEach(System.out::println);

    }
}
