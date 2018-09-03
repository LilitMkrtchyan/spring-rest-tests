package com.test.recruitment.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.test.recruitment.entity.Transaction;

import java.util.Optional;

/**
 * Transaction repository
 * 
 * @author A525125
 *
 */
public interface TransactionRepository {

    /**
     * Deletes the entity with the given transaction id.
     *
     * @param id id of the transaction to delete
     */
    void deleteById(String id);

    /**
     * Returns transaction by id
     *
     * @param id id of the transaction to get
     * @return the entity with the given id or Optional#empty() if none found
     */
    Optional<Transaction> findById(String id);


	/**
	 * Get transactions by account
	 *
	 * @param accountId
	 *            the account id
	 * @param p
	 *            the pageable information
	 * @return
	 */
	Page<Transaction> getTransactionsByAccount(String accountId, Pageable p);
}