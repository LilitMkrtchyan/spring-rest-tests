package com.test.recruitment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * AdminTransaction controller
 *
 * @author lilitmk
 */
@RequestMapping(value = "/accounts/{accountId}/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
public interface AdminTransactionController {

    /**
     * Deletes the entity with the given transactionId and accountId.
     *
     * @param accountId     the account id
     * @param transactionId the transaction id
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{transactionId}")
    void deleteTransaction(@PathVariable("accountId") String accountId, @PathVariable("transactionId") String transactionId);
}