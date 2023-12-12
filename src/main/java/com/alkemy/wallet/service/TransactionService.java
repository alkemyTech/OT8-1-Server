package com.alkemy.wallet.service;

import com.alkemy.wallet.dto.TransactionsDto;
import com.alkemy.wallet.entity.Account;
import com.alkemy.wallet.entity.Etransactions;
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

    public TransactionsDto createTransaction(TransactionsDto transactionsDto) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionsDto.getAmount());
        transaction.setDescription(transactionsDto.getDescription());
        transaction.setType(Etransactions.valueOf(transactionsDto.getType()));
        transaction.setAccountId(transactionsDto.getAccountId());



         transactionRepository.save(transaction);
         return transactionsDto;

    }
}
