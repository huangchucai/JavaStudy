package com.hcc.mybatis.mapper;

import com.hcc.mybatis.Account;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface AccountMapper {

  Account selectAccount(@Param("id") int id);

  List<Account> selectAccountList(@Param("money") int money);

  List<Account> selectAccountByName(@Param("name") String name);

  List<Account> selectAccountListByAll (@Param("orderBy") String orderBy);


  List<Account> selectActiveAccountByAll(@Param("account") Account account);

  List<Account> selectActiveAccountDefaultMoney(@Param("account") Account account, @Param("offset") Integer offset , @Param("limit") Integer limit);

  Integer countActiveAccountDefaultMoney(@Param("account") Account account);
  List<Account> selectAccountByIds(@Param("ids") List ids);

  int countAll();

  int insertAccount(@Param("account") Account account);

  int insertSelective(@Param("account") Account account);

  int insertAccountByMap(@Param("map") HashMap<String, Object> map);

  int insertAccountByParams(@Param("name") String name, @Param("money") int money);

  int updateAccount(@Param("account") Account account);

  int deleteAccount(@Param("id") int id);

}
