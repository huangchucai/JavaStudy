package com.hcc.mybatis.mapper;

import com.hcc.mybatis.Account;

import java.util.List;

public interface AccountMapper {
  Account selectAccount(int id);

  List<Account> selectAccountList(int money);

  int insertAccount(Account account);

  int updateAccount(Account account);

  int deleteAccount(int id);
}
