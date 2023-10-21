package com.hcc.spring.introduction.controller;

import com.hcc.spring.introduction.context.MyApplicationContext;
import com.hcc.spring.introduction.pojo.BankOperationResult;
import com.hcc.spring.introduction.service.IBankService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "balanceInquiryServlet", urlPatterns = "/balanceInquiry")
public class BalanceInquiryServlet extends HttpServlet {

    private IBankService bankService = MyApplicationContext.getBean(IBankService.class);
//  private IBankService bankService = new BankService();
//  private IBankService bankService = MyApplicationContext.createBean(IBankService.class);

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println(bankService);
    int id = Integer.parseInt(req.getParameter("id"));
    BankOperationResult bankOperationResult = bankService.balanceInquiry(id);
    String message;
    if (bankOperationResult.isResult()) {
      message = String.format("balance of account %d is %d yuan", id, bankOperationResult.getBalance());
    } else {
      message = String.format("balance inquiry fail, fail reason: %s", bankOperationResult.getFailReason());
    }
    resp.getWriter().write(message);
  }
}
