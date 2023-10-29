package com.hcc.spring.ioc.advance;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component("apple")
public class AppleFactory implements FactoryBean<Apple> {
    @Override
    public Apple getObject() throws Exception {
        System.out.println("AppleFactory 的getObject被 调用");
//        return new Apple();
        return new Apple("hcc");
    }

    @Override
    public Class<?> getObjectType() {
        return Apple.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
