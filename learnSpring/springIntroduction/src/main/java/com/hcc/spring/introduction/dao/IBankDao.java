package com.hcc.spring.introduction.dao;

import com.hcc.spring.introduction.pojo.AccountPO;

public interface IBankDao {
  AccountPO selectById(int id);

  int updateAccount(AccountPO accountPO);
}
