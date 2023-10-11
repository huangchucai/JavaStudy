package com.hcc.mybatis;

public class Account {
    private Integer id;

    private String name;

    private Integer money;

    private Integer age;

    private Integer status;

    private Integer gender;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Account{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", money=" + money +
            ", age=" + age +
            ", status=" + status +
            ", gender=" + gender +
            '}';
    }
}
