package com.worldline.fpl.recruitment.service;

import com.worldline.fpl.recruitment.exception.ServiceException;
import com.worldline.fpl.recruitment.json.ErrorCode;
import com.worldline.fpl.recruitment.json.TransactionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AdminTransaction service
 *
 * @author lilitmk
 */
@Slf4j
@Service
public class AdminTransactionService {
    private AccountService accountService;
    private TransactionService transactionService;

    @Autowired
    public AdminTransactionService(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    /**
     * Delete transaction for provided account by given transaction id
     *
     * @param accountId     the account id
     * @param transactionId the transaction id
     */
    public void deleteTransaction(String accountId, String transactionId) {
        log.debug("Delete {} transaction  for account {}", transactionId, accountId);
        if (!accountService.isAccountExist(accountId)) {
            log.debug("Can not find account for provided id : {}", accountId);
            throw new ServiceException(ErrorCode.NOT_FOUND_ACCOUNT,
                    "Account doesn't exist");
        }

        TransactionResponse transaction = transactionService.getTransaction(transactionId);
        if (!accountId.equals(transaction.getAccountId())) {
            log.debug("Transaction by given {} id doesn't belong to the account by {} id", accountId);
            throw new ServiceException(ErrorCode.FORBIDDEN_TRANSACTION,
                    "There is no such a transaction for provided account");
        }
        transactionService.deleteTransaction(transactionId);
    }
}