package com.test.recruitment.mapper;

import com.test.recruitment.entity.Account;
import com.test.recruitment.json.AccountDetailsResponse;
import com.test.recruitment.json.AccountResponse;
import org.springframework.stereotype.Component;

/**
 * Account mapper
 *
 * @author lilitmk
 */
@Component
public class AccountMapper {
    /**
     * Maps {@link Account} to {@link AccountResponse}
     *
     * @param account the entity
     * @return the AccountResponse
     */
    public AccountResponse mapToAccountResponse(Account account) {
        AccountResponse result = new AccountResponse();
        result.setBalance(account.getBalance());
        result.setId(account.getId());
        result.setNumber(account.getNumber());
        result.setType(account.getType());
        return result;
    }

    /**
     * Maps {@link Account} to {@link AccountDetailsResponse}
     *
     * @param account the entity
     * @return the AccountDetailsResponse
     */
    public AccountDetailsResponse mapToAccountDetailsResponse(Account account) {
        AccountDetailsResponse result = new AccountDetailsResponse();
        result.setActive(account.isActive());
        result.setCreationDate(account.getCreationDate());
        result.setBalance(account.getBalance());
        result.setId(account.getId());
        result.setNumber(account.getNumber());
        result.setType(account.getType());
        return result;
    }
}
