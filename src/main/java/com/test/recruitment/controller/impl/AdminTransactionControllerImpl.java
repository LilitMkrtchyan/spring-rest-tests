package com.test.recruitment.controller.impl;

import com.test.recruitment.controller.AdminTransactionController;
import com.test.recruitment.service.AdminTransactionService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class AdminTransactionControllerImpl implements AdminTransactionController {

    private AdminTransactionService adminTransactionService;

    @Override
    public void deleteTransaction(@PathVariable("accountId") String accountId, @PathVariable("transactionId") String transactionId) {
        adminTransactionService.deleteTransaction(accountId, transactionId);
    }
}