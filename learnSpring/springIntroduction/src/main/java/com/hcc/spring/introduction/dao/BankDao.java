package com.hcc.spring.introduction.dao;

import com.hcc.spring.introduction.mapper.AccountPOMapper;
import com.hcc.spring.introduction.pojo.AccountPO;
import com.hcc.spring.introduction.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BankDao implements IBankDao {
  @Override
  public AccountPO selectById(int id) {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountPOMapper mapper = session.getMapper(AccountPOMapper.class);
    return mapper.selectByPrimaryKey(id);
  }

  @Override
  public int updateAccount(AccountPO accountPO) {
    SqlSession session = SqlSessionUtil.getSqlSession();
    AccountPOMapper mapper = session.getMapper(AccountPOMapper.class);
    int count = mapper.updateByPrimaryKey(accountPO);
    session.commit();
    session.close();
    return count;
  }
}
