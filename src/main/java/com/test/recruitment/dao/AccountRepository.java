package com.test.recruitment.dao;

import com.test.recruitment.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Account repository
 *
 * @author A525125
 */
@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, String> {

    /**
     * Returns account
     *
     * @param id accountId the account id
     * @return the entity with the given id or Optional#empty() if none found
     */
    Optional<Account> findById(String id);
}
