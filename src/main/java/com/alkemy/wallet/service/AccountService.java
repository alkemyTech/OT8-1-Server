package com.alkemy.wallet.service;
/*Los servicios en una aplicación son responsables de manejar la lógica de negocio y las operaciones
de la base de datos*/

import com.alkemy.wallet.entity.Account;
import com.alkemy.wallet.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }


}
