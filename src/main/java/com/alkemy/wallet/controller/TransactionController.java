package com.alkemy.wallet.controller;

import com.alkemy.wallet.entity.Account;
import com.alkemy.wallet.entity.FixedTermDeposit;
import com.alkemy.wallet.entity.Transaction;
import com.alkemy.wallet.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService=transactionService;
    }

    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable Long id) {
        return transactionService.getTransaction(id);
    }

    @GetMapping("/")
    public List<Transaction> getAllTransaction() {
        return transactionService.getAllTransaction();
    }
    @PostMapping("/")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }
}
