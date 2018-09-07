package com.test.recruitment.controller.impl;

import com.test.recruitment.controller.AdminTransactionController;
import com.test.recruitment.json.CreateTransactionRequest;
import com.test.recruitment.json.UpdateTransactionRequest;
import com.test.recruitment.service.AdminTransactionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * Implementation of {@link AdminTransactionController}
 *
 * @author lilitmk
 */
@RestController
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class AdminTransactionControllerImpl implements AdminTransactionController {

    private AdminTransactionService adminTransactionService;

    @Override
    public void deleteTransaction(@PathVariable("accountId") String accountId, @PathVariable("transactionId") String transactionId) {
        adminTransactionService.deleteTransaction(accountId, transactionId);
    }

    @Override
    public void createTransaction(@PathVariable("accountId") String accountId, @Valid @RequestBody CreateTransactionRequest request) {
        adminTransactionService.createTransaction(accountId, request);
    }

    @Override
    public void updateTransaction(@PathVariable("accountId") String accountId, @PathVariable("transactionId") String transactionId, @Valid @RequestBody UpdateTransactionRequest request) {
        adminTransactionService.updateTransaction(accountId, transactionId, request);
    }
}