package com.hcc.spring.mybatis.service;

import com.hcc.spring.mybatis.mapper.AccountPOMapper;
import com.hcc.spring.mybatis.pojo.AccountPO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *Propagation.REQUIRED:  Spring默认的事务传播行为。如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
 *Propagation.SUPPORTS：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续执行。
 *Propagation.MANDATORY：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
 *Propagation.REQUIRES_NEW：创建一个新的事务，如果当前存在事务，则挂起当前事务。
 *Propagation.NOT_SUPPORTED：以非事务的方式执行操作，如果当前存在事务，则挂起当前事务。
 *Propagation.NEVER：以非事务的方式执行操作，如果当前存在事务，则抛出异常。
 *Propagation.NESTED：如果当前存在事务，则在嵌套事务内执行；如果当前没有事务，则创建一个新的事务。
 */
@Service
public class InnerService {
  @Resource
  private AccountPOMapper accountPOMapper;


  @Transactional(propagation = Propagation.NESTED)
  public void innerMethod() {
    // 给 id = 1 的账户 + 10
    AccountPO accountPO = accountPOMapper.selectByPrimaryKey(1);
    accountPO.setMoney(accountPO.getMoney() + 10);
    accountPOMapper.updateByPrimaryKey(accountPO);

    int a = 1/0;

    // 给 id = 2 的账户 + 10
    accountPO = accountPOMapper.selectByPrimaryKey(2);
    accountPO.setMoney(accountPO.getMoney() + 10);
    accountPOMapper.updateByPrimaryKey(accountPO);
  }
}
