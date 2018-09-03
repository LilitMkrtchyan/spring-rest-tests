package com.test.recruitment.mapper;

import com.test.recruitment.entity.Transaction;
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
     * Maps {@link Transaction} to {@link TransactionResponse}
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
