package com.test.recruitment.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.test.recruitment.dao.TransactionRepository;
import com.test.recruitment.entity.Transaction;
import com.test.recruitment.json.ErrorCode;
import com.test.recruitment.json.TransactionResponse;
import com.test.recruitment.exception.ServiceException;
import com.worldline.fpl.recruitment.dao.TransactionRepository;
import com.worldline.fpl.recruitment.entity.Transaction;
import com.worldline.fpl.recruitment.exception.ServiceException;
import com.worldline.fpl.recruitment.json.ErrorCode;
import com.worldline.fpl.recruitment.json.TransactionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Transaction service
 *
 * @author A525125
 */
@Slf4j
@Service
public class TransactionService {

    private AccountService accountService;

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(AccountService accountService,
                              TransactionRepository transactionRepository) {
        this.accountService = accountService;
        this.transactionRepository = transactionRepository;
    }

    /**
     * Delete transaction by provided id
     *
     * @param transactionId the transaction id
     */
    public void deleteTransaction(String transactionId) {
        log.debug("Delete transaction {}", transactionId);
        transactionRepository.deleteById(transactionId);
    }

    /**
     * Get transaction by provided id
     *
     * @param transactionId the transaction id
     * @return Transaction
     */
    public TransactionResponse getTransaction(String transactionId) {
        log.debug("Find transaction {}", transactionId);
        Transaction transaction = transactionRepository.findById(transactionId);
        if (transaction == null) {
            log.debug("Can not find transaction for provided id : {}", transactionId);
            throw new ServiceException(ErrorCode.NOT_FOUND_TRANSACTION,
                    "Transaction doesn't exist");
        }
        return map(transaction);
    }

    /**
     * Get transactions by account
     *
     * @param accountId the account id
     * @param p         the pageable object
     * @return
     */
    public Page<TransactionResponse> getTransactionsByAccount(String accountId,
                                                              Pageable p) {
        if (!accountService.isAccountExist(accountId)) {
            throw new ServiceException(ErrorCode.NOT_FOUND_ACCOUNT,
                    "Account doesn't exist");
        }
        return new PageImpl<>(transactionRepository
                .getTransactionsByAccount(accountId, p).getContent().stream()
                .map(this::map).collect(Collectors.toList()));
    }

    /**
     * Map {@link Transaction} to {@link TransactionResponse}
     *
     * @param transaction
     * @return
     */
    private TransactionResponse map(Transaction transaction) {
        TransactionResponse result = new TransactionResponse();
        result.setId(transaction.getId());
        result.setNumber(transaction.getNumber());
        result.setBalance(transaction.getBalance());
        result.setAccountId(transaction.getAccountId());
        return result;
    }
}
