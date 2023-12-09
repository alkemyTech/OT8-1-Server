package com.alkemy.wallet.controller;

import com.alkemy.wallet.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.alkemy.wallet.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }
    @GetMapping("/list")
    public ResponseEntity<Page<Account>> getPaginatedAccounts(@RequestParam(defaultValue = "0") int page) {
        Page<Account> accountsPage = accountService.getPaginatedAccounts(page);
        return ResponseEntity.ok(accountsPage);
    }    
}
