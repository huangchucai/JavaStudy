package com.hcc.spring.ioc.advance;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
public class Apple {
//    public Apple(@Value("雪梨") String name) {
//        System.out.println("Apple的有参构造函数被调用");
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                '}';
    }

    @Value("苹果")
    private String name;

    public Apple() {
        System.out.println("apple无参构造函数被调用");
    }
}
