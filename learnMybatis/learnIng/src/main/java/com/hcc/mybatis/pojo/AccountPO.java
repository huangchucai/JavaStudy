package com.hcc.mybatis.pojo;

public class AccountPO {
    private Integer id;

    private String name;

    private Integer useAge;

    private Long money;

    private Integer gender;

    private Integer status;

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

    public Integer getUseAge() {
        return useAge;
    }

    public void setUseAge(Integer useAge) {
        this.useAge = useAge;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AccountPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", useAge=" + useAge +
                ", money=" + money +
                ", gender=" + gender +
                ", status=" + status +
                '}';
    }
}
