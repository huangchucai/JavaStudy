package com.hcc.spring.springboot.request;

public class TransferMoneyRequest {
  private Integer fromAccountId;

  private Integer toAccountId;

  private Integer money;


  public Integer getFromAccountId() {
    return fromAccountId;
  }

  public void setFromAccountId(Integer fromAccountId) {
    this.fromAccountId = fromAccountId;
  }

  public Integer getToAccountId() {
    return toAccountId;
  }

  public void setToAccountId(Integer toAccountId) {
    this.toAccountId = toAccountId;
  }

  public Integer getMoney() {
    return money;
  }

  public void setMoney(Integer money) {
    this.money = money;
  }
}
