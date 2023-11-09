package com.hcc.spring.springboot.controller;

import com.hcc.spring.springboot.constant.ResponseCode;
import com.hcc.spring.springboot.excpetion.BusinessException;
import com.hcc.spring.springboot.excpetion.ParamException;
import com.hcc.spring.springboot.pojo.AccountPO;
import com.hcc.spring.springboot.pojo.Response;
import com.hcc.spring.springboot.request.TransferMoneyRequest;
import com.hcc.spring.springboot.service.IAccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//@Controller
//@ResponseBody

@RequestMapping("/account")
@RestController
public class AccountController {
  @Resource
  private IAccountService accountService;

  @RequestMapping(value = "/balanceInquiry", method = RequestMethod.GET)
  public String balanceInquiry(@RequestParam("id") Integer id) {
    return accountService.balanceInquiry(id).toString();
  }

  @RequestMapping(value = "/queryAccount", method = RequestMethod.GET)
  public AccountPO queryAccount(@RequestParam("id") Integer id) {
    return accountService.queryAccount(id);
  }


  @GetMapping("/queryAccountV2")
  public Response<AccountPO> queryAccountV2(@RequestParam("id") Integer id) {
    System.out.println("queryAccountV2 执行");
    Response<AccountPO> response = new Response<>();
    AccountPO account = accountService.queryAccount(id);
    if (account == null) {
      response.setCode(ResponseCode.PARAM_ERROR);
      response.setMessage("account not exist");
    } else {
      response.setCode(ResponseCode.SUCCESS);
      response.setData(account);
    }
    return response;
  }

  @PostMapping("/transferMoney")
  public Response<Void> transferMoney(@RequestBody TransferMoneyRequest request) {
    Response<Void> response = new Response<>();
    try {
      accountService.transferMoney(request);
    } catch (ParamException pe) {
      // 捕获参数异常
      response.setCode(ResponseCode.PARAM_ERROR);
      response.setMessage(pe.getMessage());
      return response;
    } catch (BusinessException be) {
      response.setCode(ResponseCode.BUSINESS_ERROR);
      response.setMessage(be.getMessage());
      return response;
    } catch (Exception e) {
      response.setCode(ResponseCode.UNKNOWN_ERROR);
      response.setMessage("系统异常");
      return response;
    }

    response.setCode(ResponseCode.SUCCESS);
    response.setMessage("转账成功");
    return response;
  }


}
