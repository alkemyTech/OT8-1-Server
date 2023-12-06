package com.alkemy.wallet.repo;

import com.alkemy.wallet.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}