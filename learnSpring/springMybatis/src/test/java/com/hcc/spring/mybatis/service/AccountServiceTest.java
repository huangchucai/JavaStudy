package com.hcc.spring.mybatis.service;

import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class AccountServiceTest extends BaseTest {
  @Resource
  private IAccountService accountService;

  @Test
  public void testBalanceInquiry() {
    int id = 1;
    Integer balance = accountService.balanceInquiry(id);
    String msg = String.format("balance of id %d id %d", id, balance);
    System.out.println(msg);
  }

  @Test
  public void testTransferMoney() {
    int fromAccountId = 1;
    int toAccountId = 2;
    int money = 100;
    boolean success = accountService.transferMoney(fromAccountId, toAccountId, money);
    String msg = success ? "成功" : "失败";
    System.out.println("转账" + msg);
  }

  @Test
  public void testTransferMoneyWrapper() {
    int fromAccountId = 1;
    int toAccountId = 2;
    int money = 100;
    boolean success = accountService.transferMoneyWrapper(fromAccountId, toAccountId, money);
    String msg = success ? "成功" : "失败";
    System.out.println("转账" + msg);
  }

  @Test
  public void testTransactionalRollbackFor() throws Exception {
    int accountId = 1;
    accountService.saveMoney(accountId, 100);
  }


}
