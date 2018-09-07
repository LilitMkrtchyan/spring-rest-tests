package com.test.recruitment.mapper;

import com.test.recruitment.entity.Transaction;
import com.test.recruitment.json.CreateTransactionRequest;
import com.test.recruitment.json.UpdateTransactionRequest;
import com.test.recruitment.json.TransactionResponse;
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

    /** Maps {@link Transaction} to {@link TransactionResponse}
     *
     * @param transaction the entity
     * @return TransactionResponse
     */
    public TransactionResponse mapToTransactionResponse(Transaction transaction) {
        TransactionResponse result = new TransactionResponse();
        result.setId(transaction.getId());
        result.setNumber(transaction.getNumber());
        result.setBalance(transaction.getBalance());
        result.setAccountId(transaction.getAccountId());
        return result;
    }
}
