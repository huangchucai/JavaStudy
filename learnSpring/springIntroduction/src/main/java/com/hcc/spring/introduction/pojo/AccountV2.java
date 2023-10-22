package com.hcc.spring.introduction.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("accountV2")
public class AccountV2 implements IAccount{
    @Value("2345")
    private Integer money;

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "AccountV2{" +
                "money=" + money +
                '}';
    }
}
