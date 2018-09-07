package com.test.recruitment.service;

import com.test.recruitment.dao.TransactionRepository;
import com.test.recruitment.exception.ServiceException;
import com.test.recruitment.json.ErrorCode;
import com.test.recruitment.json.TransactionResponse;
import com.test.recruitment.mapper.TransactionMapper;
import lombok.AllArgsConstructor;
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
@Service
@Slf4j
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class TransactionService {

    private AccountService accountService;

    private TransactionMapper transactionMapper;

    private TransactionRepository transactionRepository;

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
                .map(transactionMapper::mapToTransactionResponse).collect(Collectors.toList()));
    }
}