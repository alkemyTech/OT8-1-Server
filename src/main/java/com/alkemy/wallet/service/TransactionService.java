package com.alkemy.wallet.service;

import com.alkemy.wallet.entity.Account;
import com.alkemy.wallet.entity.FixedTermDeposit;
import com.alkemy.wallet.entity.Transaction;
import com.alkemy.wallet.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository=transactionRepository;}

    public Transaction getTransaction(Long id) {

        return transactionRepository.findById(id).orElse(null);
    }

    public List<Transaction> getAllTransaction() {

        return transactionRepository.findAll();
    }

    public Transaction createTransaction(Transaction transaction) {

        return transactionRepository.save(transaction);
    }
}
