package com.hcc.spring.mvc.service;

import com.hcc.spring.mvc.excpetion.ParamException;
import com.hcc.spring.mvc.pojo.AccountPO;
import com.hcc.spring.mvc.request.TransferMoneyRequest;

public interface IAccountService {
  Integer balanceInquiry(int id);

  AccountPO queryAccount(int id);

  void transferMoney(TransferMoneyRequest request) throws ParamException;
}
