package com.worldline.fpl.recruitment.dao;

import com.worldline.fpl.recruitment.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Transaction repository
 *
 * @author A525125
 */
public interface TransactionRepository {
    /**
     * Delete transaction by id
     *
     * @param id id of the transaction to delete
     */
    void deleteById(String id);

    /**
     * Get transaction by Id
     *
     * @param id id of the transaction to get
     * @return the transaction corresponding to the given id or null
     */
    Transaction findById(String id);

    /**
     * Get transactions by account
     *
     * @param accountId the account id
     * @param p         the pageable information
     * @return
     */
    Page<Transaction> getTransactionsByAccount(String accountId, Pageable p);
}