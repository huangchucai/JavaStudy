package com.hcc.spring.introduction.controller;



import com.hcc.spring.introduction.context.MyApplicationContext;
import com.hcc.spring.introduction.pojo.BankOperationResult;
import com.hcc.spring.introduction.service.BankService;
import com.hcc.spring.introduction.service.IBankService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "withdrawMoneyServlet", urlPatterns = "/withdrawMoney")
public class WithdrawMoneyServlet extends HttpServlet {

//  private IBankService bankService = new BankService();
//  private IBankService bankService =  MyApplicationContext.createBean(IBankService.class);
//  private IBankService bankService =  MyApplicationContext.getBean(IBankService.class);
private IBankService bankService = (IBankService) MyApplicationContext.getBean("bankService");

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException
  {
    System.out.println(bankService);
    int id = Integer.parseInt(req.getParameter("id"));
    int money = Integer.parseInt(req.getParameter("money"));
    BankOperationResult bankOperationResult = bankService.withdrawMoney(id, money);
    String message;
    if (bankOperationResult.isResult()) {
      message = String.format("withdraw success, balance of account %d is %d yuan", id, bankOperationResult.getBalance());
    } else {
      message = String.format("withdraw fail, fail reason: %s", bankOperationResult.getFailReason());
    }
    resp.getWriter().write(message);
  }
}
