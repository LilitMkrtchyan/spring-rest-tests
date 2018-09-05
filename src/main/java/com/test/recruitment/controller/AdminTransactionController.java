package com.test.recruitment.controller;

import com.test.recruitment.json.CreateTransactionRequest;
import com.test.recruitment.json.UpdateTransactionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Saves a given entity.
     *
     * @param accountId the account id
     * @param request   the CreateTransactionRequest entity to be mapped to entity
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createTransaction(@PathVariable("accountId") String accountId, @RequestBody CreateTransactionRequest request);

    /**
     * Updates the given entity.
     *
     * @param accountId     the account id
     * @param transactionId the transaction id
     * @param request       the UpdateTransactionRequest entity to be mapped to entity
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{transactionId}")
    void updateTransaction(@PathVariable("accountId") String accountId, @PathVariable("transactionId") String transactionId, @RequestBody UpdateTransactionRequest request);
}