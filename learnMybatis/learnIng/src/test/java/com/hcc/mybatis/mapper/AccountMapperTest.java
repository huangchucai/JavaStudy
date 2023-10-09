package com.hcc.mybatis.mapper;

import com.hcc.mybatis.Account;
import com.hcc.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
public class AccountMapperTest {
  @Test
  public void testSelectAccount() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    Account account = accountMapper.selectAccount(4);
    System.out.println(account);
    session.close();
  }


  @Test
  public void testSelectAccountListByAll() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    List<Account> accountList = accountMapper.selectAccountListByAll("id");
    System.out.println(accountList);
    session.close();
  }


  @Test
  public void testInsertAccount() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    Account account = new Account();
    account.setName("Tom");
    account.setMoney(9999);
    int count = accountMapper.insertAccount(account);
    System.out.println("插入数据" +count + "条");

    session.commit();
    session.close();
  }

  @Test
  public void testInsertAccountByMap() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    HashMap map = new HashMap<String, Object>();
    map.put("name", "mary");
    map.put("money", 1000);
    int count = accountMapper.insertAccountByMap(map);
    System.out.println("插入数据" +count + "条");

    session.commit();
    session.close();
  }

  @Test
  public void testInsertAccountByParams() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    int count = accountMapper.insertAccountByParams("Jim", 1000);
    System.out.println("插入数据" +count + "条");

    session.commit();
    session.close();
  }

  @Test
  public void testUpdateAccount() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    Account account = new Account();
    account.setId(4);
    account.setName("Tom");
    account.setMoney(999999);
    int count = accountMapper.updateAccount(account);
    System.out.println("更新数据" +count + "条");

    session.commit();
    session.close();
  }

  @Test
  public void testDeleteAccount() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    int count = accountMapper.deleteAccount(5);
    System.out.println("删除数据" +count + "条");

    session.commit();
    session.close();
  }
}
