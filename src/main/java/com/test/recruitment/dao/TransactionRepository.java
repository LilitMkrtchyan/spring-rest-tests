package com.test.recruitment.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.test.recruitment.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Transaction repository
 *
 * @author A525125
 *
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

	/**
	 * Returns transaction
	 *
	 * @param id the transaction id
	 * @return the entity with the given id or Optional#empty() if none found
	 */
	Optional<Transaction> findById(String id);

	/**
	 * Returns transactions by account
	 *
	 * @param accountId the account id
	 * @param pageable  the pageable information
	 * @return a Page
	 */
	Page<Transaction> getTransactionsByAccountId(String accountId, Pageable pageable);
}