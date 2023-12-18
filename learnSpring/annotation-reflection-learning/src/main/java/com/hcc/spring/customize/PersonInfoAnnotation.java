package com.hcc.spring.customize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PersonInfoAnnotation {
    String name() default "hcc";

    int age() default 10;

    String id();

//    String name() default "hcc11";
}
