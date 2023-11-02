package com.hcc.spring.mybatis.service;

import com.hcc.spring.mybatis.mapper.AccountPOMapper;
import com.hcc.spring.mybatis.pojo.AccountPO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class OuterService {
  @Resource
  private InnerService innerService;

  @Resource
  private AccountPOMapper accountPOMapper;

//  @Transactional
  public void outerMethod() {
    // 给id = 3 的账户 + 10
    AccountPO accountPO = accountPOMapper.selectByPrimaryKey(3);
    accountPO.setMoney(accountPO.getMoney() + 10);
    accountPOMapper.updateByPrimaryKey(accountPO);


    try {
      // 调用 inner 方法
      innerService.innerMethod();
    }catch (Exception e) {
      e.printStackTrace();
    }



    // 给 id = 4 的账户 + 10
    accountPO = accountPOMapper.selectByPrimaryKey(4);
    accountPO.setMoney(accountPO.getMoney() + 10);
    accountPOMapper.updateByPrimaryKey(accountPO);

    // 抛出异常
//    throw new RuntimeException();
  }
}
