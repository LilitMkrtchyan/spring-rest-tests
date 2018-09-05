package com.worldline.fpl.recruitment.controller.impl;

import com.worldline.fpl.recruitment.controller.AdminTransactionController;
import com.worldline.fpl.recruitment.service.AdminTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation of {@link AdminTransactionController}
 *
 * @author lilitmk
 */
@Slf4j
@RestController
public class AdminTransactionControllerImpl implements AdminTransactionController {
    private AdminTransactionService adminTransactionService;

    @Autowired
    public AdminTransactionControllerImpl(AdminTransactionService adminTransactionService) {
        this.adminTransactionService = adminTransactionService;
    }

    @Override
    public void deleteTransaction(@PathVariable("accountId") String accountId, @PathVariable("transactionId") String transactionId) {
        adminTransactionService.deleteTransaction(accountId, transactionId);
    }
}