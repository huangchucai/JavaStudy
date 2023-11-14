package com.hcc;

import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
import java.util.function.*;

/**
 * Predicate
 * Function
 * Consumer
 * Supplier
 */
public class InternalFunctionInterfaceDemo {
    public static void main(String[] args) {
        /**
         * 1. Predicate 预测(单个参数)
         */
        Predicate<Integer> isOdd = (num) -> num % 2 == 0;
        System.out.println("Predicate测试：" + isOdd.test(4));
        System.out.println("Predicate测试：" + isOdd.test(5));

        /**
         * BiPredicate (2个参数的预测）
         */
        BiPredicate<Integer, Integer> biPredicateFunction = (x, y) -> x > y;
        System.out.println("测试BiPredicate：" + biPredicateFunction.test(1,2));
        System.out.println("测试BiPredicate：" + biPredicateFunction.test(3,2));
        /**
         * 2. Function 映射 x -> y
         */
        Function<String, Integer> stringLengthFunction = String::length;
        System.out.println("Function 获取字符串长度: " + stringLengthFunction.apply("qwer"));
        // 求一个字符串的长度，然后平方
        Function<String, Integer> newFunction = stringLengthFunction.andThen((num) -> num * num);
        System.out.println("Function 字符串先长度然后平方：" + newFunction.apply("hcc"));

        /**
         * BiFunction (2个参数的预测）
         */
        BiFunction<Integer, Integer, Integer> sumFunction = (x, y) -> x + y;
        System.out.println("BiFunction两数相加：" + sumFunction.apply(1,3));

        /**
         * Function 输入和输出同一种类型UnaryOperator（1位的Function操作)
         */
        UnaryOperator<Integer> powOperator = num -> num * num;
        System.out.println("UnaryOperator测试平方" + powOperator.apply(10));

        /**
         * Function  BinaryOperator 二位的Function操作
         */
        BinaryOperator<Integer> sumOperatorFunction = (a, b) -> a * 5 + b * 10;
        System.out.println("sumOperatorFunction测试加法：" + sumOperatorFunction.apply(10, 5));

        /**
         * 3. Consumer 消费者
         */
        Consumer<String> printUpperCase = (s) -> System.out.println(s.toUpperCase());
        printUpperCase.accept("I am Cat");

        /**
         * 4. Supplier 提供者
         */
        Supplier<Integer> getMonth = () -> {
            LocalDate currentDate = LocalDate.now();
            return currentDate.getMonthValue();
        };
        System.out.println("获取当前的月份：" + getMonth.get());

        Supplier<Integer> getRandom = () -> new Random().nextInt();
        System.out.println("获取随机数字：" + getRandom.get());
    }
}
