package com.hcc.spring.springboot.service;

import com.hcc.spring.springboot.excpetion.ParamException;
import com.hcc.spring.springboot.pojo.AccountPO;
import com.hcc.spring.springboot.request.TransferMoneyRequest;

public interface IAccountService {
  Integer balanceInquiry(int id);

  AccountPO queryAccount(int id);

  void transferMoney(TransferMoneyRequest request) throws ParamException;
}
