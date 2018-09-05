package com.test.recruitment.mapper;

import com.test.recruitment.entity.Transaction;
import com.test.recruitment.json.CreateTransactionRequest;
import com.test.recruitment.json.UpdateTransactionRequest;
import org.springframework.stereotype.Component;

/**
 * Transaction mapper
 *
 * @author lilitmk
 */
@Component
public class TransactionMapper {
    /**
     * Maps {@link CreateTransactionRequest} to {@link Transaction}
     *
     * @param request the entity to be mapped
     * @return Transaction
     */
    public Transaction mapToTransaction(CreateTransactionRequest request) {
        Transaction transaction = new Transaction();
        transaction.setNumber(request.getNumber());
        transaction.setBalance(request.getBalance());
        return transaction;
    }

    /**
     * Maps {@link UpdateTransactionRequest} to {@link Transaction}
     *
     * @param request the entity to be mapped
     * @return Transaction
     */
    public Transaction mapToTransaction(UpdateTransactionRequest request) {
        Transaction transaction = new Transaction();
        transaction.setNumber(request.getNumber());
        transaction.setBalance(request.getBalance());
        return transaction;
    }
}
