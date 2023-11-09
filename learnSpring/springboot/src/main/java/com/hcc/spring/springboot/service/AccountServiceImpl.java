package com.hcc.spring.springboot.service;

import com.hcc.spring.springboot.excpetion.BusinessException;
import com.hcc.spring.springboot.excpetion.ParamException;
import com.hcc.spring.springboot.mapper.AccountPOMapper;
import com.hcc.spring.springboot.pojo.AccountPO;
import com.hcc.spring.springboot.request.TransferMoneyRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements IAccountService {

  @Resource
  private AccountPOMapper accountPOMapper;

  @Override
  public Integer balanceInquiry(int id) {
    AccountPO accountPO = accountPOMapper.selectByPrimaryKey(id);
    if (accountPO == null) {
      return null;
    } else {
      return accountPO.getMoney();
    }
  }

  @Override
  public AccountPO queryAccount(int id) {
    return accountPOMapper.selectByPrimaryKey(id);
  }

  private void paramCheck(TransferMoneyRequest request) throws ParamException {
    if (request == null) {
      throw new ParamException("request不能为空");
    }
    Integer fromAccountId = request.getFromAccountId();
    Integer toAccountId = request.getToAccountId();
    Integer money = request.getMoney();

    if (fromAccountId == null) {
      throw new ParamException("转出账户不能为空");
    }
    if (toAccountId == null) {
      throw new ParamException("转入账户不能为空");
    }
    if (money == null) {
      throw new ParamException("转账金额不能为空");
    }
    if (fromAccountId <= 0) {
      throw new ParamException("转出账户id必须大于0");
    }
    if (toAccountId <= 0) {
      throw new ParamException("转入账户id必须大于0");
    }
    if (money <= 0) {
      throw new ParamException("转账金额必须大于0");
    }

  }

  private AccountPO queryExistAccount(Integer id ) {
    AccountPO accountPO = accountPOMapper.selectByPrimaryKey(id);
    if (accountPO == null) {
      throw new BusinessException(String.format("账户 id = $d 不存在", id));
    }
    return accountPO;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void transferMoney(TransferMoneyRequest request) throws ParamException {
    // 参数检查
    paramCheck(request);
    paramCheck(request);
    int fromAccountId = request.getFromAccountId();
    int toAccountId = request.getToAccountId();
    int money = request.getMoney();

    // 获取转出账户
    AccountPO fromAccount = queryExistAccount(fromAccountId);

    // 获取转入账户
    AccountPO toAccount = queryExistAccount(toAccountId);

    // 检查转账金额大于转出账户余额
    if (money > fromAccount.getMoney()) {
      // 转账金额大于余额
      throw new BusinessException("余额不足，转账失败");
    }

    // 扣减转出账户余额
    fromAccount.setMoney(fromAccount.getMoney() - money);
    int fromCount = accountPOMapper.updateByPrimaryKeySelective(fromAccount);

    // 增加转入账户余额
    toAccount.setMoney(toAccount.getMoney() + money);
    int toCount = accountPOMapper.updateByPrimaryKeySelective(toAccount);
    if (fromCount + toCount != 2) {
      throw new RuntimeException("转账数据异常");
    }
  }
}
