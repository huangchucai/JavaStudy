package com.hcc.spring.introduction.service;

import com.hcc.spring.introduction.pojo.BankOperationResult;

public interface IBankService {
  BankOperationResult balanceInquiry(int id);

  BankOperationResult saveMoney(int id, int money);

  BankOperationResult withdrawMoney(int id, int money);
}
