package com.test.recruitment.service;

import java.util.stream.Collectors;

import com.test.recruitment.mapper.AccountMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.test.recruitment.dao.AccountRepository;
import com.test.recruitment.entity.Account;
import com.test.recruitment.json.AccountDetailsResponse;
import com.test.recruitment.json.AccountResponse;
import com.test.recruitment.json.ErrorCode;
import com.test.recruitment.exception.ServiceException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

/**
 * Account service
 *
 * @author A525125
 *
 */
@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class AccountService {

	private AccountMapper accountMapper;

	private AccountRepository accountRepository;

	/**
	 * Get account by user
	 *
	 * @param p
	 *            the pageable information
	 * @return the account list
	 */
	@Transactional(readOnly = true)
	public Page<AccountResponse> getAccounts(Pageable p) {
		return new PageImpl<>(accountRepository.findAll(p)
				.getContent().stream().map(accountMapper::mapToAccountResponse)
				.collect(Collectors.toList()));
	}

	/**
	 * Check if an account exists
	 *
	 * @param accountId
	 *            the account id
	 * @return true if the account exists
	 */
	@Transactional(readOnly = true)
	public boolean isAccountExist(String accountId) {
		return accountRepository.exists(accountId);
	}

	/**
	 * Get account details
	 *
	 * @param accountId
	 *            the account id
	 * @return
	 */
	@Transactional(readOnly = true)
	public AccountDetailsResponse getAccountDetails(String accountId) {
		log.debug("Find account {}", accountId);
		Account account = accountRepository.findById(accountId).orElseThrow(
				() -> new ServiceException(ErrorCode.NOT_FOUND_ACCOUNT,
						"Account doesn't exist"));
		return accountMapper.mapToAccountDetailsResponse(account);
	}
}