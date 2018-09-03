package com.test.recruitment.service;

import com.test.recruitment.dao.TransactionRepository;
import com.test.recruitment.entity.Transaction;
import com.test.recruitment.exception.ServiceException;
import com.test.recruitment.json.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * AdminTransaction service
 *
 * @author lilitmk
 */
@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class AdminTransactionService {

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

        Transaction transaction = getTransactionById(transactionId);
        validateAccountId(transaction.getAccountId(), accountId);
        transactionRepository.deleteById(transactionId);
    }

    /**
     * Returns transaction
     * Throws {@link ServiceException} if transaction doesn't exist.
     *
     * @param transactionId the transaction id
     * @return Transaction
     */
    private Transaction getTransactionById(String transactionId) {
        return transactionRepository.findById(transactionId).orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND_TRANSACTION,
                "Transaction doesn't exist"));
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