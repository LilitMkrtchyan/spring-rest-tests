package com.test.recruitment.service;

import com.test.recruitment.dao.TransactionRepository;
import com.test.recruitment.entity.Transaction;
import com.test.recruitment.exception.ServiceException;
import com.test.recruitment.json.AbstractTransaction;
import com.test.recruitment.json.CreateTransactionRequest;
import com.test.recruitment.json.ErrorCode;
import com.test.recruitment.json.UpdateTransactionRequest;
import com.test.recruitment.mapper.TransactionMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.UUID;

/**
 * AdminTransaction service
 *
 * @author lilitmk
 */
@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class AdminTransactionService {
    private TransactionMapper transactionMapper;
    private AccountService accountService;
    private TransactionRepository transactionRepository;

    /**
     * Deletes transaction for provided account by given transaction id
     * Throws {@link ServiceException} if account doesn't exist or transaction doesn't belong to account or undefined.
     *
     * @param accountId     the account id
     * @param transactionId the transaction id
     */
    public void deleteTransaction(String accountId, String transactionId) {
        log.debug("Delete {} transaction  for account {}", transactionId, accountId);
        Assert.hasText(accountId, "Account id should be provided");
        Assert.hasText(transactionId, "Transaction id should be provided");

        Transaction transaction = getTransaction(transactionId);
        validateAccountId(transaction.getAccountId(), accountId);
        transactionRepository.deleteById(transactionId);
    }

    /**
     * Creates transaction.
     * Throws {@link ServiceException} if account doesn't exist.
     *
     * @param accountId the account id
     * @param request   the entity to be mapped to Transaction
     */
    public void createTransaction(String accountId, CreateTransactionRequest request) {
        log.debug("Create transaction for {} account", accountId);
        Assert.hasText(accountId, "Account id should be provided");
        validateTransaction(request);

        checkIsAccountExist(accountId);
        Transaction transaction = transactionMapper.mapToTransaction(request);
        transaction.setAccountId(accountId);
        transaction.setId(UUID.randomUUID().toString());
        transactionRepository.save(transaction);
    }

    /**
     * Updates transaction
     * Throws {@link ServiceException} if account doesn't exist or transaction doesn't belong to account.
     *
     * @param accountId     the account id
     * @param transactionId the transaction id
     * @param request       the entity to be mapped to Transaction
     */
    public void updateTransaction(String accountId, String transactionId, UpdateTransactionRequest request) {
        log.debug("Update {} transaction for {} account", transactionId, accountId);
        Assert.hasText(accountId, "Account id should be provided");
        Assert.hasText(transactionId, "Transaction id should be provided");
        validateTransaction(request);

        checkIsAccountExist(accountId);
        Transaction transaction = getTransaction(transactionId);
        validateAccountId(transaction.getAccountId(), accountId);
        transaction.setNumber(request.getNumber());
        transaction.setBalance(request.getBalance());
        Transaction t = transactionMapper.mapToTransaction(request);
        t.setId(transactionId);
        transactionRepository.save(t);


    }

    /**
     * Returns transaction
     * Throws {@link ServiceException} if transaction doesn't exist.
     *
     * @param transactionId the transaction id
     * @return Transaction
     */
    private Transaction getTransaction(String transactionId) {
        return transactionRepository.findById(transactionId).orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND_TRANSACTION,
                "Transaction doesn't exist"));
    }

    /**
     * Checks is account exists or not
     * Throws {@link ServiceException} if account doesn't exist.
     *
     * @param accountId the account id
     */
    private void checkIsAccountExist(String accountId) {
        if (!accountService.isAccountExist(accountId)) {
            log.debug("Account by given {} id doesn't exist", accountId);
            throw new ServiceException(ErrorCode.NOT_FOUND_ACCOUNT,
                    "Account doesn't exist");
        }
    }

    /**
     * Validates {@link AbstractTransaction}
     * Throws {@link IllegalArgumentException} or {@link IllegalStateException} in case of invalid data
     *
     * @param transaction the entity to be validated
     */
    private void validateTransaction(AbstractTransaction transaction) {
        Assert.notNull(transaction, "Transaction can not be null");
        Assert.hasText(transaction.getNumber(), "Number should be provided");
        Assert.notNull(transaction.getBalance(), "Balance should be provided");
    }

    /**
     * Checks if strings are equal
     * Throws {@link ServiceException} if transaction doesn't belong to the account.
     *
     * @param accountId  the account id that belongs to the transaction
     * @param providedId the given id
     */
    private void validateAccountId(String accountId, String providedId) {
        if (!accountId.equals(providedId)) {
            log.debug("Transaction by given {} id doesn't belong to the account by {} id", accountId);
            throw new ServiceException(ErrorCode.FORBIDDEN_TRANSACTION,
                    "There is no such a transaction for provided account");
        }
    }
}