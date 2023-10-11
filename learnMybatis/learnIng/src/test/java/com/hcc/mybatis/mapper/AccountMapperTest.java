package com.hcc.mybatis.mapper;

import com.hcc.mybatis.Account;
import com.hcc.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
  public void testSelectAccountByName() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    List<Account> account = accountMapper.selectAccountByName("tom");
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
  public void testCountAll() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    int count = accountMapper.countAll();
    System.out.println("查询到" + count + "条数据");
  }

  @Test
  public void testInsertAccount() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    Account account = new Account();
    account.setName("Tom");
    account.setMoney(9999);
    int count = accountMapper.insertAccount(account);
    System.out.println("插入数据" + count + "条");

    session.commit();
    session.close();
  }

  @Test
  public void testInsertAccountByMap() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("name", "mary");
    map.put("money", 1000);
    int count = accountMapper.insertAccountByMap(map);
    System.out.println("插入数据" + count + "条");

    session.commit();
    session.close();
  }

  @Test
  public void testSelectActiveAccountByGender() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    Account account = new Account();
    account.setGender(0);
    List<Account> accountList = accountMapper.selectActiveAccountByAll(account);
    System.out.println("-----根据性别筛选-----");
    for (Account data : accountList) {
      System.out.println(data);
    }
  }

  @Test
  public void testSelectActiveAccountDefaultMoney() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    Account account = new Account();
    account.setAge(18);
    List<Account> accountList = accountMapper.selectActiveAccountDefaultMoney(account, 0, 5);
    System.out.println("-----根据年龄筛选-----");
    for (Account data : accountList) {
      System.out.println(data);
    }

    account = new Account();
    account.setGender(1);
    accountList = accountMapper.selectActiveAccountDefaultMoney(account, 0 ,8);
    System.out.println("-----根据性别筛选-----");
    for (Account data : accountList) {
      System.out.println(data);
    }

    account = new Account();
    accountList = accountMapper.selectActiveAccountDefaultMoney(account, 0, 15);
    System.out.println("-----年龄性别都为空，根据money>1000 查询-----");
    for (Account data : accountList) {
      System.out.println(data);
    }
  }

  @Test
  public void countActiveAccountDefaultMoney() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    Account account = new Account();
//    account.setGender(1);
    Integer count = accountMapper.countActiveAccountDefaultMoney(account);
    System.out.println("-----根据性别筛选---统计数量-----" + count);
  }

  @Test
  public void testSelectActiveAccountByAge() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    Account account = new Account();
    account.setAge(18);
    List<Account> accountList = accountMapper.selectActiveAccountByAll(account);
    System.out.println("-----根据年龄筛选-----");
    for (Account data : accountList) {
      System.out.println(data);
    }
  }

  @Test
  public void selectAccountByIds() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    List<Integer> ids = new ArrayList();
//    ids.add(1);
//    ids.add(3);
//    ids.add(6);
    List<Account> accountList = accountMapper.selectAccountByIds(ids);
    System.out.println("-----根据指定的id查询-----");
    for (Account data : accountList) {
      System.out.println(data);
    }
  }

  @Test
  public void testSelectActiveAccountByAgeAndGender() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    Account account = new Account();
    account.setAge(18);
    account.setGender(0);
    List<Account> accountList = accountMapper.selectActiveAccountByAll(account);
    System.out.println("-----根据年龄和性别筛选-----");
    for (Account data : accountList) {
      System.out.println(data);
    }
  }

  @Test
  public void testInsertAccountByParams() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    int count = accountMapper.insertAccountByParams("Jim", 1000);
    System.out.println("插入数据" + count + "条");

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
    System.out.println("更新数据" + count + "条");

    session.commit();
    session.close();
  }

  @Test
  public void insertSelective() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    Account account = new Account();
    account.setName("Alice");
    account.setAge(19);
    account.setMoney(147852);
//    account.setStatus(1);
    int count = accountMapper.insertSelective(account);
    System.out.println("插入数据" + count + "条");

    session.commit();
    session.close();
  }

  @Test
  public void testDeleteAccount() {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
    int count = accountMapper.deleteAccount(5);
    System.out.println("删除数据" + count + "条");

    session.commit();
    session.close();
  }
}
